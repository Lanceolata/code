# Apache Airflow

Apache Airflow (or simply Airflow) is a platform to programmatically author, schedule, and monitor workflows.

When workflows are defined as code, they become more maintainable, versionable, testable, and collaborative.

Use Airflow to author workflows as directed acyclic graphs (DAGs) of tasks. The Airflow scheduler executes your tasks on an array of workers while following the specified dependencies. Rich command line utilities make performing complex surgeries on DAGs a snap. The rich user interface makes it easy to visualize pipelines running in production, monitor progress, and troubleshoot issues when needed.

## 相关项目及文档

[官网](http://airflow.apache.org/)

[官方文档](http://airflow.apache.org/docs/apache-airflow/stable/index.html)

[项目](https://github.com/apache/airflow)

## 安装

        export SLUGIFY_USES_TEXT_UNIDECODE=yes

        python3 install --user psycopg2-binary
        #python3 install --user apache-airflow[crypto,hdfs,mysql,postgres,password]
        python3 install --user apache-airflow[crypto,hdfs,postgres,password]

        echo "########################################################"
        echo "copy to .bashrc:"
        echo "export AIRFLOW_HOME=\"$AIRFLOW_HOME\""
        echo "export PATH=\"$BIN:\$PATH\""

## 使用

1. 初始化

        初始化数据库
        airflow initdb
        设置配置文件
        conf/airflow.cfg

2. 启动

        DAGS_DIR="$AIRFLOW_HOME/dags"
        LOG_DATE=$(date '+%Y%m%d')
        LOG_DIR="$AIRFLOW_HOME/server_logs/"
        WEBSERVER_LOG="$LOG_DIR/webserver_$LOG_DATE.log"
        SCHEDULER_LOG="$LOG_DIR/scheduler_$LOG_DATE.log"
        mkdir -p $DAGS_DIR
        mkdir -p $LOG_DIR

        airflow webserver >> $WEBSERVER_LOG 2>&1 &
        airflow scheduler >> $SCHEDULER_LOG 2>&1 &

3. 停止

        ps -ef | grep "airflow webserver" | grep -v grep | awk '{print $2}' | xargs kill
        ps -ef | grep "airflow scheduler" | grep -v grep | awk '{print $2}' | xargs kill

4. 初始化用户名和密码

        python

        import airflow
        from airflow import models, settings
        from airflow.contrib.auth.backends.password_auth import PasswordUser
        user = PasswordUser(models.User())
        user.username = 'airflow'
        user.email = 'airflow@lanceolata'
        user.password = 'airflow@lanceolata'
        session = settings.Session()
        session.add(user)
        session.commit()
        session.close()
        exit()

5. 配置PostgreSQL作为单机数据库

        创建用户
        createuser -P airflow
        airflow.lanceolata
        创建库
        createdb -O airflow airflow
        验证
        psql -U airflow -W
        airflow.lanceolata

## 常见问题

1. ImportError: This platform lacks a functioning sem_open implementation, therefore, the required synchronization primitives needed will not function, see issue 3770.

    python 3770 bug，需要找SRE修复。

2. 代理

- 1.8不支持代理，以系统时间为准，不区分时区
- 1.9不支持代理，时区为utc
- 1.10区分时区，支持代理，webserver前端显示为utc时间，调度不受影响，但通过Macros传入的日期需处理

3. undefined symbol: PyUnicodeUCS4_DecodeUTF8

        重装python
        ./configure --enable-unicode=ucs4
        make && make install

4. Python 3.6 及以上 module 'enum' has no attribute 'IntFlag'

        pip3 uninstall enum34
