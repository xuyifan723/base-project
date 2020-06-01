package com.xyf.trans.enums;

/**
 * @Author: xuyifan
 * @Date: 2020/6/1
 */
public enum  UniqueType {
    //全文索引，目前只有MyISAM引擎支持
    FULLTEXT,
    //普通索引
    NORMAL,
    //空间索引  MyISAM and InnoDB支持空间和非空间索引
    SPATIAL,
    //只在“=”和“in”条件下高效，对于范围查询、排序及组合索引仍然效率不高
    HASH,
    //将索引值按一定的算法，存入一个树形的数据结构中（二叉树）,每次查询都是从树的入口root开始，依次遍历node，获取leaf
    BTREE,
    //在MySQL很少使用，仅支持geometry数据类型
    RTREE,
    //唯一索引
    UNIQUE;
}
