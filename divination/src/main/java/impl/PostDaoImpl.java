package impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Post;
import dao.PostDaoTest;
import service.PostService;
import util.ConnectionSMMS;


public class PostDaoImpl implements PostDaoTest{
QueryRunner queryRunner=new QueryRunner(ConnectionSMMS.createMSSQLConnection());
	@Override
	public List<Post> searchAll() {
		String sql="select * from post";
		try {
			List<Post> postList= queryRunner.query(sql, new BeanListHandler<Post>(Post.class) {
				
				public List<Post> handle(ResultSet rs) throws SQLException{
					List<Post> postList= new ArrayList();
					while(rs.next()) {
						Post p = new Post();
						p.setpostId(rs.getInt("postId"));
						p.setpostTitle(rs.getString("postTitle"));
						p.setpostDate(rs.getString("postDate"));
						p.setpostContent(rs.getString("postContent"));
						p.setpostLike(rs.getString("postLike"));
						p.setpostDislike(rs.getString("postDislike"));
						p.setpostComment(rs.getString("postComment"));

						postList.add(p);
					}
					return postList;
				}
			});
				return postList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int delete(Integer postId) {
		String sql="delete from post where postId=?";
		try {
			int result= queryRunner.update(sql,postId);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int update(Post post) {
		String sql="update post set postTitle= ?,postDate= ?,postContent= ?,postLike= ?,postDislike= ?,postComment= ? where postId= ?";
		try {
			int result= queryRunner.update(sql,post.getpostTitle(),post.getpostDate(),post.getpostContent(),post.getpostLike(),post.getpostDislike(),post.getpostComment(),post.getpostId());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Post searchById(Integer postId) {
		String sql="select * from post where postId=?";
		
		try {
			Post classbean = queryRunner.query(sql, new BeanHandler<Post>(Post.class),postId);
				return classbean;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int add(Post post) {
		String sql = "insert into post (postTitle,postDate,postContent,postLike,postDislike,postComment) values (?,?,?,?,?,?)";
		try {
			int result= queryRunner.update(sql,post.getpostTitle(),post.getpostDate(),post.getpostContent(),post.getpostLike(),post.getpostDislike(),post.getpostComment());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
