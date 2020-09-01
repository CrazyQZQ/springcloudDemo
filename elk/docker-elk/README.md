# Docker安装RabbitMQ + ELK

#### 使用说明

1.  请先安装docker和docker-compose;
2.  将docker-elk文件夹上传到服务器
3.  在docker-elk文件夹下执行命令，docker load < rabbitmq-elk_images.tar，导入镜像，成功后通过docker images可以看到RabbitMQ,Elastic Search，Logstash和Kibana的镜像；
4.  在docker-elk文件夹下执行docker-compose build命令，构建镜像，之后执行docker-compose up -d 命令启动镜像，Rabbit+ELK容器启动需要1分钟左右；
5.  通过docker ps -a 查看容器是否启动，通过docker logs 容器ID查看容器日志，通过tail -f -n 100 /var/lib/docker/容器ID/容器ID.json实时查看日志；
6.  容器启动后输入服务器IP+端口5601进入Kibana界面，用户名:elastic，密码：elk654123
7.  在Kibana左侧的Management菜单下下添加索引，在Discover菜单下查看索引
