package EEIT56_23;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utile.ConnectionSMMS;

public class PeopleDaoImpl_23 implements PeopleDao_23 {

//	private static Logger log = LoggerFactory.getLogger(PeopleDaoImpl_23.class);

	Connection conn;

//	public PeopleDaoImpl_23(Connection conn) {
//		this.conn = conn;
//	}

//	public PeopleDaoImpl_23() {
//	}
	PeopleBean_23 pb = new PeopleBean_23();

	QueryRunner queryRunner = new QueryRunner(ConnectionSMMS.createMSSQLConnection());
//
//	@Override
//	public List<PeopleBean_23> selectAll() {
//		String sql = "select * from people";
//		try {
//			List<PeopleBean_23> list = queryRunner.query(sql, new BeanListHandler<PeopleBean_23>(PeopleBean_23.class));
//			return list;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	@Override
	public List<PeopleBean_23> selectAll() {
		String sql = "select * from people_23";
		try {
			List<PeopleBean_23> list = queryRunner.query(sql, new BeanListHandler<PeopleBean_23>(PeopleBean_23.class) {
				public List<PeopleBean_23> handle(ResultSet rs) throws SQLException {
					List<PeopleBean_23> pbl = new ArrayList();
					while (rs.next()) {
						PeopleBean_23 bean = new PeopleBean_23();
						bean.setUserID(rs.getInt("userID"));
						bean.setName(rs.getString("Name"));
						bean.setAge(rs.getInt("userAge"));
						bean.setSex(rs.getString("sex"));
						bean.setAddress(rs.getString("Address"));
						bean.setImages(rs.getBlob("person_img"));
						bean.setStar(rs.getString("star_sign"));
						bean.setEmotion(rs.getString("emotion"));
						bean.setProfession(rs.getString("Profession"));
						bean.setPersonality(rs.getString("personality"));
						bean.setHobby(rs.getString("hobby"));
						bean.setDream(rs.getString("dream"));
						bean.setIntroduction(rs.getString("introduction"));
						bean.setReligion(rs.getString("religion"));
						bean.setSex_in(rs.getString("sex_orientation"));
						bean.setIncome(rs.getDouble("income"));

						pbl.add(bean);
					}
					return pbl;
				}
			});
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PeopleBean_23 selectById(int id) {
		String sql = "select * from people_23 where userID =?";
		try {
			PeopleBean_23 people = queryRunner.query(sql, new BeanHandler<PeopleBean_23>(PeopleBean_23.class) {
				public PeopleBean_23 handle(ResultSet rs) throws SQLException {
					while (rs.next()) {
						pb.setUserID(rs.getInt("userID"));
						pb.setName(rs.getString("Name"));
						pb.setAge(rs.getInt("userAge"));
						pb.setSex(rs.getString("sex"));
						pb.setAddress(rs.getString("Address"));
						pb.setImages(rs.getBlob("person_img"));
						pb.setStar(rs.getString("star_sign"));
						pb.setEmotion(rs.getString("emotion"));
						pb.setProfession(rs.getString("Profession"));
						pb.setPersonality(rs.getString("personality"));
						pb.setHobby(rs.getString("hobby"));
						pb.setDream(rs.getString("dream"));
						pb.setIntroduction(rs.getString("introduction"));
						pb.setReligion(rs.getString("religion"));
						pb.setSex_in(rs.getString("sex_orientation"));
						pb.setIncome(rs.getDouble("income"));

					}
					return pb;
				}
			}, id);
			return people;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("PeopleBean_23()#querypeople()發生例外: " + e.getMessage());
		}
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM people_23 WHERE userID = ?";

		try {
			int result = queryRunner.update(sql, id);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}

	@Override
	public int update(PeopleBean_23 bean) {
		String sql = "update people_23 set Name=?, userAge=?, Address=?, person_img=?,"
				+ " star_sign=?, emotion=?, Profession=?, personality=?, hobby=?,"
				+ " dream=?, introduction=?, religion=?, income=?, sex_orientation=? where userID=?";

		try {
			int result = queryRunner.update(sql, bean.getName(), bean.getAge(), bean.getAddress(),
					bean.getImages(), bean.getStar(), bean.getEmotion(), bean.getProfession(), bean.getPersonality(),
					bean.getHobby(), bean.getDream(), bean.getIntroduction(), bean.getReligion(), bean.getIncome(),
					bean.getSex_in(), bean.getUserID());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void save(PeopleBean_23 bean) {
		String sql = "insert into people_23" + "(userid, Name, userAge, sex, Address, person_img,"
				+ " star_sign, emotion, Profession, personality, hobby,"
				+ " dream, introduction, religion, income, sex_orientation)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			queryRunner.update(sql, bean.getUserID(), bean.getName(), bean.getAge(), bean.getSex(), bean.getAddress(),
					bean.getImages(), bean.getStar(), bean.getEmotion(), bean.getProfession(), bean.getPersonality(),
					bean.getHobby(), bean.getDream(), bean.getIntroduction(), bean.getReligion(), bean.getIncome(),
					bean.getSex_in());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("PeopleDaoImpl_23()#save()發生例外: " + e.getMessage());
		}

	}

	@Override
	public void saveNoIncome(PeopleBean_23 bean) {
		String sql = "insert into people_23" + "(userid, Name, userAge, sex, Address, person_img,"
				+ " star_sign, emotion, Profession, personality, hobby,"
				+ " dream, introduction, religion,  sex_orientation)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			queryRunner.update(sql, bean.getUserID(), bean.getName(), bean.getAge(), bean.getSex(), bean.getAddress(),
					bean.getImages(), bean.getStar(), bean.getEmotion(), bean.getProfession(), bean.getPersonality(),
					bean.getHobby(), bean.getDream(), bean.getIntroduction(), bean.getReligion(), bean.getSex_in());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("PeopleDaoImpl_23()#save()發生例外: " + e.getMessage());
		}

	}
	
	public void saveTest(PeopleBean_23 bean) {
		String sql = "insert into people_23" + "(userid, Name, userAge, sex, Address)" + " values (?,?,?,?,?)";
		try {
			queryRunner.update(sql, bean.getUserID(), bean.getName(), bean.getAge(), bean.getSex(), bean.getAddress());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PeopleBean_23 selectAge(int id) {
		String sql = "select userAge from people_23 where userId=?";
		try {
			PeopleBean_23 classbean = queryRunner.query(sql, new BeanHandler<PeopleBean_23>(PeopleBean_23.class) {

				public PeopleBean_23 handle(ResultSet rs) throws SQLException {

					while (rs.next()) {
						pb.setAge(rs.getInt("userAge"));
					}
					return pb;
				}
			}, id);
			return classbean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PeopleBean_23 findImageById(int Id) {
		String sql = "select person_img from people_23 where userId=?";
		try {
			PeopleBean_23 classbean = queryRunner.query(sql, new BeanHandler<PeopleBean_23>(PeopleBean_23.class) {

				public PeopleBean_23 handle(ResultSet rs) throws SQLException {

					while (rs.next()) {
						pb.setImages(rs.getBlob("person_img"));
					}
					return pb;
				}
			}, Id);
			return classbean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<PeopleBean_23> selectByIdOrName(int id, String name) {
		String sql = "select * from people_23 where name like ?";
		String sql2 = "select * from people_23 where userId=?";
		try {
			List<PeopleBean_23> listName = queryRunner.query(sql, new BeanListHandler<PeopleBean_23>(PeopleBean_23.class) {
				public List<PeopleBean_23> handle(ResultSet rs) throws SQLException {
					List<PeopleBean_23> pbl = new ArrayList();
					while (rs.next()) {
						PeopleBean_23 bean = new PeopleBean_23();
						bean.setUserID(rs.getInt("userID"));
						bean.setName(rs.getString("Name"));
						bean.setAge(rs.getInt("userAge"));
						bean.setSex(rs.getString("sex"));
						bean.setAddress(rs.getString("Address"));
						bean.setImages(rs.getBlob("person_img"));
						bean.setStar(rs.getString("star_sign"));
						bean.setEmotion(rs.getString("emotion"));
						bean.setProfession(rs.getString("Profession"));
						bean.setPersonality(rs.getString("personality"));
						bean.setHobby(rs.getString("hobby"));
						bean.setDream(rs.getString("dream"));
						bean.setIntroduction(rs.getString("introduction"));
						bean.setReligion(rs.getString("religion"));
						bean.setSex_in(rs.getString("sex_orientation"));
						bean.setIncome(rs.getDouble("income"));

						pbl.add(bean);
					}
					return pbl;
				}
			},"%"+name+"%");

			List<PeopleBean_23> listId = queryRunner.query(sql2, new BeanListHandler<PeopleBean_23>(PeopleBean_23.class) {
				public List<PeopleBean_23> handle(ResultSet rs) throws SQLException {
					List<PeopleBean_23> pbl = new ArrayList();
					while (rs.next()) {
						PeopleBean_23 bean = new PeopleBean_23();
						bean.setUserID(rs.getInt("userID"));
						bean.setName(rs.getString("Name"));
						bean.setAge(rs.getInt("userAge"));
						bean.setSex(rs.getString("sex"));
						bean.setAddress(rs.getString("Address"));
						bean.setImages(rs.getBlob("person_img"));
						bean.setStar(rs.getString("star_sign"));
						bean.setEmotion(rs.getString("emotion"));
						bean.setProfession(rs.getString("Profession"));
						bean.setPersonality(rs.getString("personality"));
						bean.setHobby(rs.getString("hobby"));
						bean.setDream(rs.getString("dream"));
						bean.setIntroduction(rs.getString("introduction"));
						bean.setReligion(rs.getString("religion"));
						bean.setSex_in(rs.getString("sex_orientation"));
						bean.setIncome(rs.getDouble("income"));

						pbl.add(bean);
					}
					return pbl;
				}
			},id);
			if (id != 0) {
				return listId;
			} else {
				return listName;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("PeopleBean_23()#querypeople()發生例外: " + e.getMessage());
		}

	}

}
