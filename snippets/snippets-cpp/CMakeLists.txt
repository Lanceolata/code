cmake_minimum_required(VERSION 2.8.10)
# 项目
# 名称 语言
project(snippets-cpp C CXX)

# 选项
# 名称 说明 默认值
option(WITH_GLOG "With glog" OFF)
option(DEBUG "Print debug logs" OFF)

if(POLICY CMP0042)
    cmake_policy(SET CMP0042 NEW)
endif()

set(CMAKE_INSTALL_PREFIX "${PROJECT_SOURCE_DIR}/install")

# 添加 math 子目录
add_subdirectory(src)
