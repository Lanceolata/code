# Python3

## 安装

        BASE_INSTALL_DIR=""
        VERSION="3.9.1"
        URL="https://www.python.org/ftp/python/${VERSION}/Python-${VERSION}.tgz"
        BASEDIR="Python-${VERSION}"
        INSTALL_DIR="$BASE_INSTALL_DIR/$BASEDIR"
        LINK_PATH="$BASE_INSTALL_DIR/python3"
        BIN="$LINK_PATH/bin"

        mkdir -p $INSTALL_DIR
        wget $URL
        tar -zvxf Python-${VERSION}.tgz
        cd $BASEDIR
        ./configure --prefix=$INSTALL_DIR --enable-unicode=ucs4
        make
        make install

        ln -sf $INSTALL_DIR $LINK_PATH

        echo "########################################################"
        echo "copy to ~.bashrc:"
        echo "export PATH=\"$BIN:\$PATH\""

## 常见问题

1. ModuleNotFoundError: No module named '_ctypes'


        需要安装新包libffi-devel
        sudo apt-get isntall libffi-dev

