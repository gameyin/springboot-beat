CREATE TABLE `t_user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nickname` varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `phone` varchar(255) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;