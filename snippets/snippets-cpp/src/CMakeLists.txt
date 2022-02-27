
# 加入一个配置头文件，用于处理 CMake 对源码的设置
configure_file (
  "config.h.in"
  "${PROJECT_SOURCE_DIR}/src/config.h"
)

# 是否使用自己的 sub 库
option(USE_SUB "use sub" OFF)

# 是否加入 sub 库
if (USE_SUB)
  # include路径
  include_directories(sub)
  # 添加 math 子目录
  add_subdirectory(sub)
  set (EXTRA_LIBS ${EXTRA_LIBS} test)
endif (USE_MYMATH)

# 查找指定目录下的所有源文件 并将名称保存到 DIR_SRCS 变量
# 目录 变量名
aux_source_directory(. DIR_SRCS)
# 指定生成可执行文件 支持指定多个源文件
# 可执行文件名称 源文件名称
add_executable(server ${DIR_SRCS})
# 添加链接库
target_link_libraries(server ${EXTRA_LIBS})

install (TARGETS server DESTINATION bin)
install (FILES config.h DESTINATION include)
