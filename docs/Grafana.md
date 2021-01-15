# Grafana

Grafana is an open source, feature rich metrics dashboard and graph editor for Graphite, Elasticsearch, OpenTSDB, Prometheus and InfluxDB.

## 相关项目及文档

[项目](https://github.com/grafana/grafana)

[官方文档](https://grafana.com/)

## 安装

        VERSION="7.3.7"
        URL="https://dl.grafana.com/oss/release/grafana-$VERSION.linux-amd64.tar.gz"
        BASEDIR="grafana-$VERSION"
        INSTALL_DIR="$BASE_INSTALL_DIR/$BASEDIR"
        BIN="$INSTALL_DIR/bin"

        mkdir -p $INSTALL_DIR
        wget $URL
        tar -zvxf "grafana-$VERSION.linux-amd64.tar.gz"
        cd $BASEDIR
        cp -r * $INSTALL_DIR

        echo "########################################################"
        echo "copy to ~.bashrc:"
        echo "export PATH=\"$BIN:\$PATH\""

## 使用

1. 启动

        cd $INSTALL_DIR
        bin/grafana-server -config "$INSTALL_DIR/conf/grafana.ini" >> "$INSTALL_DIR/grafana-start.log" 2>&1 &

2. 停止

        ps -ef | grep "grafana-server" | grep -v grep | awk '{print $2}' | xargs kill

## 相关配置
