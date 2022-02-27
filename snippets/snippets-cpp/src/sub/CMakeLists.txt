
# 查找指定目录下的所有源文件 并将名称保存到 DIR_SRCS 变量
# 目录 变量名
aux_source_directory(. SUB_DIR_SRCS)

# 指定生成可执行文件 支持指定多个源文件
# 可执行文件名称 源文件名称
add_library(test ${SUB_DIR_SRCS})

install (TARGETS test DESTINATION bin)
install (FILES test.h DESTINATION include)
