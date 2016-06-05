package com.fmy.dao;

import java.util.List;
import java.util.Map;

import com.fmy.entity.Comment;
import com.fmy.entity.CommentWithBLOBs;
import com.fmy.vo.ProductVo;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommentWithBLOBs record);

    int insertSelective(CommentWithBLOBs record);

    CommentWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CommentWithBLOBs record);

    int updateByPrimaryKey(Comment record);
    
    List<ProductVo> getProductVoListByProId(String proId);
    
    List<Comment> getCommentListByProId(String proId);
    
    int deleteByProIds(String ids);
    
    List<Comment> getAllComments() ;
    
    List<Comment> getProCommentsByPage(Map<String , Object> map) ;
}