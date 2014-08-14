Smash
=====

Smash Test

## 难度
- 1-8，8个数字不重复组成4位数字
- 每回合竞猜得到猜中的数字，如猜中的数字所在位置也正确一并返回

## 解法
- 建立一个数字集合，类似于{1,2,3,4}{1,2,3,4}{1,2,3,4}{1,2,3,4}{5,6,7,8}{5,6,7,8}{5,6,7,8}{5,6,7,8}
- 第一轮1234
- 第二轮5678
- 确认的数字保留，4个位置猜过但不会的数字会从数字集合中删除
- 重复竞猜直到获得准确结果

## 结果（2000000次）
- 耗时 95.501 秒
- 10次内命中次数 2000000
- 10次内命中率 1.000
- 10次内命中平均回合数  5.902

## 结果（20000000次）
- 耗时 924.303 秒
- 10次内命中次数 20000000
- 10次内命中率 1.000
- 10次内命中平均回合数  5.898

