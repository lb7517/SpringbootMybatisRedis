本项目使用 springboot+mybatis+redis+mysql
    注意: util -> RedisUtil中的setRedisTemplate防止入缓存乱码逻辑
          resources中注意application.properties格式(中文会乱码)，使用application.yml文件在使用
          中文配置是不会乱码。

    application.properties
        demo.name = "my spring"
        demo.author = "lb"

    application.yml
        demo:
            name: "my spring"
            author: "lb"