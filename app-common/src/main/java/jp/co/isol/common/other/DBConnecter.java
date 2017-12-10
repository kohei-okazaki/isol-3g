package jp.co.isol.common.other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB接続クラス
 *
 */
public class DBConnecter {

	/**
	 * DBに接続する
	 */
	public void connect() {

		try {
			Class.forName("org.h2.work");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection("jdbc:h2:DB")) {
			con.setAutoCommit(false);

//			String sql = "DELETE FROM USER_INFO WHERE = ?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setInt(1, 1);
//			int result = ps.executeUpdate();
//			System.out.println(result != 0 ? result + "件のデータを削除しました" : "該当するデータはいませんでした");
//			ps.close();

			String sql = "SELECT * FROM HEALTH_INFO WHERE DATA_ID = ?";
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, "1");

				try (ResultSet resultSet = ps.executeQuery()) {
					while (resultSet.next()) {
						System.out.println(resultSet.getString("ID"));
					}
				}
			}

			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
