# PostgreSQL

PostgreSQL is a powerful, open source object-relational database system that uses and extends the SQL language combined with many features that safely store and scale the most complicated data workloads. The origins of PostgreSQL date back to 1986 as part of the POSTGRES project at the University of California at Berkeley and has more than 30 years of active development on the core platform.

PostgreSQL has earned a strong reputation for its proven architecture, reliability, data integrity, robust feature set, extensibility, and the dedication of the open source community behind the software to consistently deliver performant and innovative solutions. PostgreSQL runs on all major operating systems, has been ACID-compliant since 2001, and has powerful add-ons such as the popular PostGIS geospatial database extender. It is no surprise that PostgreSQL has become the open source relational database of choice for many people and organisations.

## 相关项目及文档

[官网](https://www.postgresql.org/)

## 安装

        VERSION="13.1"
        URL="https://ftp.postgresql.org/pub/source/v$VERSION/postgresql-$VERSION.tar.gz"
        BASEDIR="postgresql-$VERSION"
        INSTALL_DIR="$BASE_INSTALL_DIR/$BASEDIR"
        BIN="$INSTALL_DIR/bin"
        LD_LIBRARY="$INSTALL_DIR/lib"
        
        mkdir -p $INSTALL_DIR
        wget $URL
        tar -zvxf postgresql-$VERSION.tar.gz
        cd $BASEDIR
        ./configure --prefix=$INSTALL_DIR
        make
        make check
        make install

        echo "########################################################"
        echo "copy to ~.bashrc:"
        echo "export LD_LIBRARY_PATH=\"$LD_LIBRARY:\$LD_LIBRARY_PATH\""
        echo "export PGDATA=\"$PGDATA\""
        echo "export PATH=\"$BIN:\$PATH\""
        echo "########################################################"
        echo "init db:"
        echo "initdb"

## 使用

1. 初始化db

        initdb

2. 启动

        PGDATA="$INSTALL_DIR/data"
        LOG_DIR="$INSTALL_DIR/log"
        LOG_PATH="$LOG_DIR/server.log"

        mkdir -p $LOG_DIR
        pg_ctl -D $PGDATA -l $LOG_PATH start

3. 停止

        pg_ctl -D $PGDATA stop

## 常见问题

1. configure: error: the HTTP rewrite module requires the PCRE library.

        sudo apt-get install libpcre3 libpcre3-dev

2. configure: error: SSL modules require the OpenSSL library.

        sudo apt-get install openssl libssl-dev

3. configure: error: the GeoIP module requires the GeoIP library.

        sudo apt-get install libgeoip1 libgeoip-dev

4. zlib

        sudo apt-get install zlib1g-dev
