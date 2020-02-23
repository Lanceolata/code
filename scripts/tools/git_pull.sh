#!/usr/bin/env bash

CUR_DIR=$(pwd)

for i in $@
do
    echo "---------------------------------------------"
    echo "git pull $i"
    cd $i
    git pull
    cd $CUR_DIR
done
