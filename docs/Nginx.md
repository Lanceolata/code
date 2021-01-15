# Nginx

## 相关项目及文档

[官网](http://nginx.org/en/)

## 安装

        NGINX_USER="lanceolata"
        NGINX_GROUP="lanceolata"
        VERSION="1.18.0"
        URL="http://nginx.org/download/nginx-$VERSION.tar.gz"
        BASEDIR="nginx-$VERSION"
        INSTALL_DIR="$BASE_INSTALL_DIR/$BASEDIR"
        BIN="$INSTALL_DIR/sbin"

        mkdir -p $INSTALL_DIR
        wget $URL
        tar -zvxf "nginx-$VERSION.tar.gz"
        cd $BASEDIR
        ./configure --prefix=$INSTALL_DIR --user=$NGINX_USER --group=$NGINX_GROUP --with-http_ssl_module --with-http_realip_module --with-http_geoip_module --with-http_stub_status_module
        make
        make install

        echo "########################################################"
        echo "copy to ~.bashrc:"
        echo "export PATH=\"$BIN:\$PATH\""

## 使用

1. 启动

        $INSTALL_DIR/sbin/nginx -c $INSTALL_DIR/conf/nginx.conf

2. 停止

        $INSTALL_DIR/sbin/nginx -s stop

## 常见问题
