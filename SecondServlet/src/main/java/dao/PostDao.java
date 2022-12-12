package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Post;
import utile.ConnectionSMMS;

public class PostDao {
	
QueryRunner queryRunner = new QueryRunner(ConnectionSMMS.createMSSQLConnection());
	

	//新增資料
	public void add(Integer postId, String postTitle, String postDate, String postContent, String postLike, String postDislike, String postComment) throws SQLException {
		String sql = "insert into post (postTitle, postDate, postContent, postLike, postDislike, postComment) values (?,?,?,?,?,?)";
		Object[] params = {postTitle, postDate, postContent, postLike, postDislike, postComment};
		int row = queryRunner.update(sql, params);
		System.out.println("已新增 " + row + " 則貼文");
	}
	
	//搜尋全部
	public List<Post> searchAll() throws SQLException {
		String sql = "select * from post";
		List<Post> list = queryRunner.query(sql, new BeanListHandler<Post>(Post.class));
		for (Post p : list) {
			System.out.println(p);
		}
		return list;
	}
	
	//用id搜尋
	public Post searchById(Integer postId) {
		String sql = "select * from post where postId = ?";

		try {
			Post p = queryRunner.query(sql, new BeanHandler<Post>(Post.class), postId);
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//模糊搜尋
//	public List<Post> search(String PostTitle) throws SQLException {
//		String sql = "select * from post where PostTitle like ?";
//		PreparedStatement preState = conn.prepareStatement(sql);
//		preState.setString(1, "%" + PostTitle + "%");
//		ResultSet rs = preState.executeQuery();
//		
//		List<Post> list = new LinkedList<Post>();
//		
//		while(rs.next()) {
//			Post p1 = new Post();
//			p1.setPostID(rs.getInt("PostID"));
//			p1.setPostTitle(rs.getString("PostTitle"));
//			p1.setPostDate(rs.getString("PostDate"));
//			p1.setPostContent(rs.getString("PostContent"));
//			p1.setPostLike(rs.getString("PostLike"));
//			p1.setPostDislike(rs.getString("PostDislike"));
//			p1.setPostComment(rs.getString("PostComment"));
//			list.add(p1);
//		}
//		
//		rs.close();
//		preState.close();
//		
//		return list;
//	}
	
	//修改資料
	public void update(int postId, String postTitle, String postDate, String postContent, String postLike, String postDislike, String postComment) throws SQLException {
		String sql = "update post set postTitle= ?,postDate= ?,postContent= ?,postLike= ?,postDislike= ?,postComment= ? where postId= ? ";
//		String sql1 = "select * from post where PostID= ? ";
		int row = queryRunner.update(sql, postId, postTitle, postDate, postContent, postLike, postDislike, postComment);
//		Post p = queryRunner.query(sql1, new BeanHandler<Post>(Post.class), PostID);
		if (row > 0) {
			System.out.println("已成功更新了 " + row + " 則貼文");
		}
		}
			
	//用ID刪除
	public void delete(Integer postId) throws SQLException {
		String sql = "delete from post where postId = ?";
		int row = queryRunner.update(sql, postId);
		if(row > 0) {
			System.out.println("成功刪除 " + row + " 則貼文");
		}else {
			System.out.println("無法刪除，找不到相關貼文");
		}
	}					 	
}
