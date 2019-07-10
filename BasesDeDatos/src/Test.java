import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import com.mysql.jdbc.Driver;

public class Test {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int option = 0;
		do {
			System.out
					.print("Escoja que quiere hacer con la base de datos:\n1.Insertar Datos\n2.Querys\n3.Salir\n");
			option = sc.nextInt();
			sc.nextLine();
			if (option == 1) {
				int option2 = 0;
				do {
					System.out
							.print("1.Insertar Canal\n2.Insertar Categoria\n3 Insertar Video\n4.Insertar Canal Recomendado(Canal - Canal)\n5.Insertar Redireccion(Categoria - Video)\n6.Salir\n");
					option2 = sc.nextInt();
					sc.nextLine();
					if (option2 == 1) {
						insertarCanal();
					} else if (option2 == 2) {
						insertarCategoria();
					} else if (option2 == 3) {
						insertarVideo();
					} else if (option2 == 4) {
						insertarCanalRecomendado();
					} else if (option2 == 5) {
						insertarRedireccion();
					} else if (option2 != 6) {
						System.out
								.println("Por favor escoja un numero dentro del rango");
						option2 = 1;
					}
				} while (option2 > 0 && option2 < 6);
			} else if (option == 2) {
				int option2 = 0;
				int last = 20;
				do {
					System.out.println("Escoja que query desea realizar");
					System.out
							.println("1.Canales ordenados respecto a sus suscriptores");
					System.out
							.println("2.Canales ordenados por orden alfabetico");
					System.out
							.println("3.Videos ordenados por orden alfabetico");
					System.out.println("4.Videos ordenados por duracion");
					System.out.println("5.Videos ordenados por vistas");
					System.out.println("6.Videos ordenados por me gusta");
					System.out.println("7.Videos ordenados por no me gusta");
					System.out.println("8.Videos ordenados por fecha");
					System.out
							.println("9.Categorias ordenadas por orden alfabetico");
					System.out
							.println("10.Categorias ordenadas por suscriptores");
					System.out
							.println("11.Canales con mas o menos de n suscriptores");
					System.out
							.println("12.Videos con mas o menos de n de duracion");
					System.out.println("13.Videos con mas o menos de n vistas");
					System.out
							.println("14.Videos con mas o menos de n me gusta");
					System.out
							.println("15.Videos con mas o menos de n no me gusta");
					System.out
							.println("16.Categoria con mas o menos de n suscriptores ");
					System.out.println("17.Canales con sus respectivos videos");
					System.out
							.println("18.Canales que señalan a otros canales");
					System.out
							.println("19.Categorias con sus respectivos videos");
					option2 = sc.nextInt();
					if (option2 >= 1 && option2 <= 10) {
						int opt3 = 0;
						do {
							System.out
									.println("Quiere que los datos esten en forma ascendente?\n1.Si\n2.No");
							opt3 = sc.nextInt();
							if (opt3 != 1 && opt3 != 2) {
								System.out
										.println("Por favor responda si o no");
							}
						} while (opt3 != 1 && opt3 != 2);
						int opt2 = 0;
						do {
							System.out
									.println("Desea limitar la cantidad de datos que aparezcan?\n1.Si\n2.No");
							opt2 = sc.nextInt();
							if (opt2 == 1) {
								int datos = 0;
								do {
									System.out
											.println("Cuantos datos desea que aparezcan?");
									datos = sc.nextInt();
									if (datos < 0) {
										System.out
												.println("No puedo hacer que aparezcan "
														+ datos + " lineas");
									}
								} while (datos < 0);
								queryAsThat(option2, datos, opt3 == 1);
							} else if (opt2 == 2) {
								queryAsThat(option2, opt3 == 1);
							} else {
								System.out.println("Por favor responda 1 o 2");
							}
						} while (opt2 != 1 && opt2 != 2);
					} else if (option2 >= 11 && option2 <= 16) {
						System.out.println("Ingrese el n a comparar");
						int n = sc.nextInt();
						int opt = 0;
						do {
							System.out
									.println("Desea que el relacionador sea n < a comparar?\n1.Si\n2.No");
							opt = sc.nextInt();
							if (opt != 1 && opt != 2) {
								System.out
										.println("Por favor responda si o no");
							}
						} while (opt != 1 && opt != 2);
						int opt2 = 0;
						do {
							System.out
									.println("Quiere que los datos esten en forma ascendente?\n1.Si\n2.No");
							opt2 = sc.nextInt();
							if (opt2 != 1 && opt2 != 2) {
								System.out
										.println("Por favor responda si o no");
							}
						} while (opt2 != 1 && opt2 != 2);
						int opt3 = 0;
						do {
							System.out
									.println("Desea limitar la cantidad de datos que aparezcan?\n1.Si\n2.No");
							opt3 = sc.nextInt();
							if (opt3 != 1 && opt3 != 2) {
								System.out.println("Por favor responda 1 o 2");
							}
						} while (opt3 != 1 && opt3 != 2);
						if (opt3 == 1) {
							int datos = 0;
							do {
								System.out
										.println("Cuantos datos desea que aparezcan?");
								datos = sc.nextInt();
								if (datos < 0) {
									System.out
											.println("No puedo hacer que aparezcan "
													+ datos + " lineas");
								}
							} while (datos < 0);
							queryMayorMenor(option2, n, opt == 1, opt2 == 1,
									true, datos);
						} else {
							queryMayorMenor(option2, n, opt == 1, opt2 == 1,
									false, 0);
						}
					} else if (option2 == 17) {
						queryPropietario();
					} else if (option2 == 18) {
						queryRecomendado();
					} else if (option2 == 19) {
						queryRedireccion();
					} else if (option2 != last) {
						option2 = 1;
						System.out
								.println("Por favor escoja un numero dentro del rango");
					}
				} while (option2 > 0 && option2 < last);
			} else if (option == 3) {
				System.out.println("Bye!");
			} else if (option != 3) {
				System.out
						.println("Por favor escoja un numero dentro del rango");
				option = 1;
			}
		} while (option < 3 && option > 0);
	}

	private static void queryRedireccion() {
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select a.*, b.* from categoria as a, video as b, redireccion as c where a.link_categoria = c.categoria_link and c.video_link = b.link_video;");
			System.out
					.println("Redireccion\nLink Categoria | Nombre Categoria | Personas Suscritas | Link | Nombre | Duracion(s) | Vistas | Me Gusta | No Me Gusta | Fecha");
			while (rs.next()) {
				String one = rs.getString(1);
				String two = rs.getString(2);
				String three = rs.getString(3);
				String four = rs.getString(4);
				String five = rs.getString(5);
				String six = rs.getString(6);
				String seven = rs.getString(7);
				String eigth = rs.getString(8);
				String nine = rs.getString(9);
				String ten = rs.getString(10);
				System.out.println(one + " | " + two + " | " + three + " | "
						+ four + " | " + five + " | " + six + " | " + seven
						+ " | " + eigth + " | " + nine + " | " + ten);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void queryRecomendado() {
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select a.*, b.* from canal as a, canal as b, canales_recomendados as c where a.link_canal = c.canal_link_1 and c.canal_link_2 = b.link_canal;");
			System.out
					.println("Canales Recomendados\nLink Canal 1 | Nombre Canal 1 | Personas Suscritas Canal 1 | Link Canal 2 | Nombre Canal 2 | Personas Suscritas Canal 2");
			while (rs.next()) {
				String one = rs.getString(1);
				String two = rs.getString(2);
				String three = rs.getString(3);
				String four = rs.getString(4);
				String five = rs.getString(5);
				String six = rs.getString(6);
				System.out.println(one + " | " + two + " | " + three + " | "
						+ four + " | " + five + " | " + six);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void queryPropietario() {
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			rs = stmt
					.executeQuery("select a.*, b.* from canal as a, video as b, propietario as c where a.link_canal = c.canal_link and c.video_link = b.link_video;");
			System.out
					.println("Propietario\nLink Canal | Nombre Canal | Personas Suscritas Canal | Link | Nombre | Duracion(s) | Vistas | Me Gusta | No Me Gusta | Fecha");
			while (rs.next()) {
				String one = rs.getString("link_canal");
				String two = rs.getString("nombre_canal");
				String three = rs.getString("personas_suscritas_canal");
				String four = rs.getString("link_video");
				String five = rs.getString("nombre_video");
				String six = rs.getString("duracion_video");
				String seven = rs.getString("vistas_video");
				String eight = rs.getString("me_gusta_video");
				String nine = rs.getString("no_me_gusta_video");
				String ten = rs.getString("fecha_video");
				System.out.println(one + " | " + two + " | " + three + " | "
						+ four + " | " + five + " | " + six + " | " + seven
						+ " | " + eight + " | " + nine + " | " + ten);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void queryMayorMenor(int opt, long n, boolean relacionador,
			boolean asc, boolean limit, int datos) {
		// relacionador true si n < comparar
		String query = "select * from ";
		if (opt == 11) {
			query += "canal ";
		} else if (opt >= 12 && opt <= 15) {
			query += "video ";
		} else if (opt == 16) {
			query += "categoria ";
		}
		query += "where ";
		if (opt == 11) {
			query += "personas_suscritas_canal ";
		} else if (opt == 12) {
			query += "duracion_video ";
		} else if (opt == 13) {
			query += "vistas_video ";
		} else if (opt == 14) {
			query += "me_gusta_video ";
		} else if (opt == 15) {
			query += "no_me_gusta_video ";
		} else if (opt == 16) {
			query += "personas_suscritas ";
		}
		if (relacionador) {
			query += "> ";
		} else {
			query += "< ";
		}
		query += n + " order by ";
		if (opt == 11) {
			query += "personas_suscritas_canal ";
		} else if (opt == 12) {
			query += "duracion_video ";
		} else if (opt == 13) {
			query += "vistas_video ";
		} else if (opt == 14) {
			query += "me_gusta_video ";
		} else if (opt == 15) {
			query += "no_me_gusta_video ";
		} else if (opt == 16) {
			query += "personas_suscritas ";
		}
		if (asc) {
			query += "asc ";
		} else {
			query += "desc ";
		}
		if (limit) {
			query += "limit " + datos + ";";
		} else {
			query += ";";
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (opt == 11) {
				System.out
						.println("Canal\nLink Canal | Nombre Canal | Personas Suscritas Canal");
				while (rs.next()) {
					String one = rs.getString("link_canal");
					String two = rs.getString("nombre_canal");
					String three = rs.getString("personas_suscritas_canal");
					System.out.println(one + " | " + two + " | " + three);
				}
			} else if (opt >= 12 && opt <= 15) {
				System.out.println("Video");
				System.out
						.println("Link | Nombre | Duracion(s) | Vistas | Me Gusta | No Me Gusta | Fecha");
				while (rs.next()) {
					String one = rs.getString("link_video");
					String two = rs.getString("nombre_video");
					String three = rs.getString("duracion_video");
					String four = rs.getString("vistas_video");
					String five = rs.getString("me_gusta_video");
					String six = rs.getString("no_me_gusta_video");
					String seven = rs.getString("fecha_video");
					System.out.println(one + " | " + two + " | " + three
							+ " | " + four + " | " + five + " | " + six + " | "
							+ seven);
				}
			} else if (opt == 16) {
				System.out.println("Categoria");
				System.out.println("Link | Nombre | Personas Suscritas");
				while (rs.next()) {
					String one = rs.getString("link_categoria");
					String two = rs.getString("nombre_categoria");
					String three = rs.getString("personas_suscritas");
					System.out.println(one + " | " + two + " | " + three);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void queryAsThat(int i, boolean asc) {
		String query = "select * from ";
		if (i == 1 || i == 2) {
			query += "canal ";
		} else if (i >= 3 && i <= 8) {
			query += "video ";
		} else if (i == 9 || i == 10) {
			query += "categoria ";
		}
		query += "order by ";
		if (i == 1) {
			query += "personas_suscritas_canal desc;";

		} else if (i == 2) {
			query += "nombre_canal ";
		} else if (i == 3) {
			query += "nombre_video ";
		} else if (i == 4) {
			query += "duracion_video ";
		} else if (i == 5) {
			query += "vistas_video ";
		} else if (i == 6) {
			query += "me_gusta_video ";
		} else if (i == 7) {
			query += "no_me_gusta_video ";
		} else if (i == 8) {
			query += "fecha_video ";
		} else if (i == 9) {
			query += "nombre_categoria ";
		} else if (i == 10) {
			query += "personas_suscritas ";
		}
		if (asc) {
			query += "asc;";
		} else {
			query += "desc;";
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (i == 1 || i == 2) {
				System.out
						.println("Canal\nLink Canal | Nombre Canal | Personas Suscritas Canal");
				while (rs.next()) {
					String one = rs.getString("link_canal");
					String two = rs.getString("nombre_canal");
					String three = rs.getString("personas_suscritas_canal");
					System.out.println(one + " | " + two + " | " + three);
				}
			} else if (i >= 3 && i <= 8) {
				System.out.println("Video");
				System.out
						.println("Link | Nombre | Duracion(s) | Vistas | Me Gusta | No Me Gusta | Fecha");
				while (rs.next()) {
					String one = rs.getString("link_video");
					String two = rs.getString("nombre_video");
					String three = rs.getString("duracion_video");
					String four = rs.getString("vistas_video");
					String five = rs.getString("me_gusta_video");
					String six = rs.getString("no_me_gusta_video");
					String seven = rs.getString("fecha_video");
					System.out.println(one + " | " + two + " | " + three
							+ " | " + four + " | " + five + " | " + six + " | "
							+ seven);
				}
			} else if (i == 9 || i == 10) {
				System.out.println("Categoria");
				System.out.println("Link | Nombre | Personas Suscritas");
				while (rs.next()) {
					String one = rs.getString("link_categoria");
					String two = rs.getString("nombre_categoria");
					String three = rs.getString("personas_suscritas");
					System.out.println(one + " | " + two + " | " + three);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void queryAsThat(int i, int limit, boolean asc) {
		String query = "select * from ";
		if (i == 1 || i == 2) {
			query += "canal ";
		} else if (i >= 3 && i <= 8) {
			query += "video ";
		} else if (i == 9 || i == 10) {
			query += "categoria ";
		}
		query += "order by ";
		if (i == 1) {
			query += "personas_suscritas_canal ";

		} else if (i == 2) {
			query += "nombre_canal ";
		} else if (i == 3) {
			query += "nombre_video ";
		} else if (i == 4) {
			query += "duracion_video ";
		} else if (i == 5) {
			query += "vistas_video ";
		} else if (i == 6) {
			query += "me_gusta_video ";
		} else if (i == 7) {
			query += "no_me_gusta_video ";
		} else if (i == 8) {
			query += "fecha_video ";
		} else if (i == 9) {
			query += "nombre_categoria ";
		} else if (i == 10) {
			query += "personas_suscritas ";
		}
		if (asc) {
			query += "asc ";
		} else {
			query += "desc ";
		}
		query += "limit " + limit + ";";
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if (i == 1 || i == 2) {
				System.out
						.println("Canal\nLink Canal | Nombre Canal | Personas Suscritas Canal");
				while (rs.next()) {
					String one = rs.getString("link_canal");
					String two = rs.getString("nombre_canal");
					String three = rs.getString("personas_suscritas_canal");
					System.out.println(one + " | " + two + " | " + three);
				}
			} else if (i >= 3 && i <= 8) {
				System.out.println("Video");
				System.out
						.println("Link | Nombre | Duracion(s) | Vistas | Me Gusta | No Me Gusta | Fecha");
				while (rs.next()) {
					String one = rs.getString("link_video");
					String two = rs.getString("nombre_video");
					String three = rs.getString("duracion_video");
					String four = rs.getString("vistas_video");
					String five = rs.getString("me_gusta_video");
					String six = rs.getString("no_me_gusta_video");
					String seven = rs.getString("fecha_video");
					System.out.println(one + " | " + two + " | " + three
							+ " | " + four + " | " + five + " | " + six + " | "
							+ seven);
				}
			} else if (i == 9 || i == 10) {
				System.out.println("Categoria");
				System.out.println("Link | Nombre | Personas Suscritas");
				while (rs.next()) {
					String one = rs.getString("link_categoria");
					String two = rs.getString("nombre_categoria");
					String three = rs.getString("personas_suscritas");
					System.out.println(one + " | " + two + " | " + three);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void insertarRedireccion() {
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			System.out
					.print("Inserte el link del video al que redirecciona la categoria\n");
			String linkVideo = sc.nextLine();
			rs = stmt.executeQuery("select * from video where link_video = '"
					+ linkVideo + "';");
			boolean comp = rs.next();
			if (!comp) {
				System.out.print("Inserte el nombre del video\n");
				String toProcess = sc.nextLine();
				String nombre = acceptable(toProcess);
				System.out.print("Inserte la duracion del video en segundos\n");
				int duracion = sc.nextInt();
				sc.nextLine();
				System.out.print("Inserte cuantas vistas tiene el video\n");
				int vistas = sc.nextInt();
				sc.nextLine();
				System.out.print("Inserte cuantos me gusta tiene el video\n");
				int meGusta = sc.nextInt();
				sc.nextLine();
				System.out
						.print("Inserte cuantos no me gusta tiene el video\n");
				int noMeGusta = sc.nextInt();
				sc.nextLine();
				System.out
						.print("Inserte la fecha del video en el formato AAAA-MM-DD\n");
				String fecha = sc.nextLine();
				stmt.executeUpdate("insert into video values('" + linkVideo
						+ "','" + nombre + "','" + duracion + "','" + vistas
						+ "','" + meGusta + "','" + noMeGusta + "','" + fecha
						+ "');");
				rs = stmt
						.executeQuery("select * from video where link_video = '"
								+ linkVideo + "';");
				System.out.println("Video");
				System.out
						.println("Link | Nombre | Duracion(s) | Vistas | Me Gusta | No Me Gusta | Fecha");
				while (rs.next()) {
					String one = rs.getString("link_video");
					String two = rs.getString("nombre_video");
					String three = rs.getString("duracion_video");
					String four = rs.getString("vistas_video");
					String five = rs.getString("me_gusta_video");
					String six = rs.getString("no_me_gusta_video");
					String seven = rs.getString("fecha_video");
					System.out.println(one + " | " + two + " | " + three
							+ " | " + four + " | " + five + " | " + six + " | "
							+ seven);
				}
				System.out
						.println("Ingrese el link del canal al que pertenece este video");
				String linkC = sc.nextLine();
				rs = stmt
						.executeQuery("select * from canal where link_canal = '"
								+ linkC + "';");
				comp = rs.next();
				if (!comp) {
					System.out.print("Inserte el nombre del canal\n");
					toProcess = sc.nextLine();
					String nombreC = acceptable(toProcess);
					System.out
							.print("Inserte cuantas personas estan suscritas al canal\n"
									+ "");
					int personasSuscritasC = sc.nextInt();
					sc.nextLine();
					stmt.executeUpdate("insert into canal values('" + linkC
							+ "','" + nombreC + "','" + personasSuscritasC
							+ "');");
					rs = stmt
							.executeQuery("select * from canal where link_canal = '"
									+ linkC + "';");
					System.out.println("Canal");
					System.out.println("Link | Nombre | Personas Suscritas");
					while (rs.next()) {
						String one = rs.getString("link_canal");
						String two = rs.getString("nombre_canal");
						String three = rs.getString("personas_suscritas_canal");
						System.out.println(one + " | " + two + " | " + three);
					}
				}
				stmt.executeUpdate("insert into propietario values('" + linkC
						+ "','" + linkVideo + "');");
				rs = stmt
						.executeQuery("select * from propietario where canal_link = '"
								+ linkC
								+ "' and video_link = '"
								+ linkVideo
								+ "';");
				System.out.println("Propietario");
				System.out.println("Link Canal | Link Video");
				while (rs.next()) {
					String one = rs.getString("canal_link");
					String two = rs.getString("video_link");
					System.out.println(one + " | " + two);
				}
			}
			System.out
					.print("Inserte el link de la categoria que redirecciona al video\n");
			String linkCategoria = sc.nextLine();
			rs = stmt
					.executeQuery("select * from categoria where link_categoria = '"
							+ linkCategoria + "';");
			comp = rs.next();
			if (!comp) {
				System.out.print("Inserte el nombre de la categoria\n");
				String toProcess = sc.nextLine();
				String nombre = acceptable(toProcess);
				System.out
						.print("Inserte cuantas personas estan suscritas a la categoria\n");
				int personasSuscritas = sc.nextInt();
				sc.nextLine();
				stmt.executeUpdate("insert into categoria values('"
						+ linkCategoria + "','" + nombre + "','"
						+ personasSuscritas + "');");
				rs = stmt
						.executeQuery("select * from categoria where link_categoria = '"
								+ linkCategoria + "';");
				System.out.println("Categoria");
				System.out.println("Link | Nombre | Personas Suscritas");
				while (rs.next()) {
					String one = rs.getString("link_categoria");
					String two = rs.getString("nombre_categoria");
					String three = rs.getString("personas_suscritas");
					System.out.println(one + " | " + two + " | " + three);
				}
			}
			stmt.executeUpdate("insert into redireccion values('"
					+ linkCategoria + "','" + linkVideo + "');");
			rs = stmt
					.executeQuery("select * from redireccion where categoria_link = '"
							+ linkCategoria
							+ "'and video_link = '"
							+ linkVideo
							+ "';");
			System.out.println("Redireccion");
			System.out.println("Link Categoria |Link Video");
			while (rs.next()) {
				String one = rs.getString("categoria_link");
				String two = rs.getString("video_link");
				System.out.println(one + " | " + two);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void insertarCanalRecomendado() {
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			String link = "";
			System.out.print("Inserte el link del canal referenciador\n");
			link = sc.nextLine();
			rs = stmt.executeQuery("select * from canal where link_canal = '"
					+ link + "';");
			boolean comp = rs.next();
			if (!comp) {
				System.out.print("Inserte el nombre del canal\n");
				String toProcess = sc.nextLine();
				String nombre = acceptable(toProcess);
				System.out
						.print("Inserte cuantas personas estan suscritas al canal\n");
				int personasSuscritas = sc.nextInt();
				sc.nextLine();
				stmt.executeUpdate("insert into canal values('" + link + "','"
						+ nombre + "','" + personasSuscritas + "');");
				rs = stmt
						.executeQuery("select * from canal where link_canal = '"
								+ link + "';");
				System.out.println("Canal");
				System.out.println("Link | Nombre | Personas Suscritas");
				while (rs.next()) {
					String one = rs.getString("link_canal");
					String two = rs.getString("nombre_canal");
					String three = rs.getString("personas_suscritas_canal");
					System.out.println(one + " | " + two + " | " + three);
				}
			}
			System.out.print("Inserte el link del canal referenciado\n");
			String link2 = sc.nextLine();
			rs = stmt.executeQuery("select * from canal where link_canal = '"
					+ link2 + "';");
			comp = rs.next();
			if (!comp) {
				System.out.print("Inserte el nombre del canal\n");
				String toProcess = sc.nextLine();
				String nombre2 = acceptable(toProcess);
				System.out
						.print("Inserte cuantas personas estan suscritas al canal\n"
								+ "");
				int personasSuscritas2 = sc.nextInt();
				sc.nextLine();
				stmt.executeUpdate("insert into canal values('" + link2 + "','"
						+ nombre2 + "','" + personasSuscritas2 + "');");
				rs = stmt
						.executeQuery("select * from canal where link_canal = '"
								+ link2 + "';");
				System.out.println("Canal");
				System.out.println("Link | Nombre | Personas Suscritas");
				while (rs.next()) {
					String one = rs.getString("link_canal");
					String two = rs.getString("nombre_canal");
					String three = rs.getString("personas_suscritas_canal");
					System.out.println(one + " | " + two + " | " + three);
				}
			}
			stmt.executeUpdate("insert into canales_recomendados values('"
					+ link + "','" + link2 + "');");
			rs = stmt
					.executeQuery("select * from canales_recomendados where canal_link_1 = '"
							+ link + "'and canal_link_2 = '" + link2 + "';");
			System.out.println("Canales Recomendados");
			System.out.println("Link Canal 1 |Link Canal 2");
			while (rs.next()) {
				String one = rs.getString("canal_link_1");
				String two = rs.getString("canal_link_2");
				System.out.println(one + " | " + two);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void insertarCanal() {
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			String link = "";
			boolean comp = true;
			do {
				System.out.print("Inserte el link del canal\n");
				link = sc.nextLine();
				rs = stmt
						.executeQuery("select * from canal where link_canal = '"
								+ link + "';");
				comp = rs.next();
				if (comp) {
					System.out
							.print("Este link ya pertenece a la tabla, por favor ingrese otro\n");
				}
			} while (comp);
			System.out.print("Inserte el nombre del canal\n");
			String toProcess = sc.nextLine();
			String nombre = acceptable(toProcess);
			System.out
					.print("Inserte cuantas personas estan suscritas al canal\n");
			int personasSuscritas = sc.nextInt();
			sc.nextLine();
			stmt.executeUpdate("insert into canal values('" + link + "','"
					+ nombre + "','" + personasSuscritas + "');");
			rs = stmt.executeQuery("select * from canal where link_canal = '"
					+ link + "';");
			System.out.println("Canal");
			System.out.println("Link | Nombre | Personas Suscritas");
			while (rs.next()) {
				String one = rs.getString("link_canal");
				String two = rs.getString("nombre_canal");
				String three = rs.getString("personas_suscritas_canal");
				System.out.println(one + " | " + two + " | " + three);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void insertarCategoria() {
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			String link = "";
			boolean comp = true;
			do {
				System.out.print("Inserte el link de la categoria\n");
				link = sc.nextLine();
				rs = stmt
						.executeQuery("select * from categoria where link_categoria = '"
								+ link + "';");
				comp = rs.next();
				if (comp) {
					System.out
							.println("Este link ya pertenece a la tabla, por favor ingrese otro\n");
				}
			} while (comp);
			System.out.print("Inserte el nombre de la categoria\n");
			String toProcess = sc.nextLine();
			String nombre = acceptable(toProcess);
			System.out
					.print("Inserte cuantas personas estan suscritas a la categoria\n");
			int personasSuscritas = sc.nextInt();
			sc.nextLine();
			stmt.executeUpdate("insert into categoria values('" + link + "','"
					+ nombre + "','" + personasSuscritas + "');");
			rs = stmt
					.executeQuery("select * from categoria where link_categoria = '"
							+ link + "';");
			System.out.println("Categoria");
			System.out.println("Link | Nombre | Personas Suscritas");
			while (rs.next()) {
				String one = rs.getString("link_categoria");
				String two = rs.getString("nombre_categoria");
				String three = rs.getString("personas_suscritas");
				System.out.println(one + " | " + two + " | " + three);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void insertarVideo() {
		String connectionUrl = "jdbc:mysql://localhost:3306/youtube";
		String connectionUser = "";
		String connectionPassword = "";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();
			String link = "";
			boolean comp = true;
			do {
				System.out.print("Inserte el link del video\n");
				link = sc.nextLine();
				rs = stmt
						.executeQuery("select * from video where link_video = '"
								+ link + "';");
				comp = rs.next();
				if (comp) {
					System.out
							.print("Este link ya pertenece a la tabla, por favor ingrese otro\n");
				}
			} while (comp);
			System.out.print("Inserte el nombre del video\n");
			String toProcess = sc.nextLine();
			String nombre = acceptable(toProcess);
			System.out.print("Inserte la duracion del video en segundos\n");
			int duracion = sc.nextInt();
			sc.nextLine();
			System.out.print("Inserte cuantas vistas tiene el video\n");
			int vistas = sc.nextInt();
			sc.nextLine();
			System.out.print("Inserte cuantos me gusta tiene el video\n");
			int meGusta = sc.nextInt();
			sc.nextLine();
			System.out.print("Inserte cuantos no me gusta tiene el video\n");
			int noMeGusta = sc.nextInt();
			sc.nextLine();
			System.out
					.print("Inserte la fecha del video en el formato AAAA-MM-DD\n");
			String fecha = sc.nextLine();
			stmt.executeUpdate("insert into video values('" + link + "','"
					+ nombre + "','" + duracion + "','" + vistas + "','"
					+ meGusta + "','" + noMeGusta + "','" + fecha + "');");
			rs = stmt.executeQuery("select * from video where link_video = '"
					+ link + "';");
			System.out.println("Video");
			System.out
					.println("Link | Nombre | Duracion(s) | Vistas | Me Gusta | No Me Gusta | Fecha");
			while (rs.next()) {
				String one = rs.getString("link_video");
				String two = rs.getString("nombre_video");
				String three = rs.getString("duracion_video");
				String four = rs.getString("vistas_video");
				String five = rs.getString("me_gusta_video");
				String six = rs.getString("no_me_gusta_video");
				String seven = rs.getString("fecha_video");
				System.out.println(one + " | " + two + " | " + three + " | "
						+ four + " | " + five + " | " + six + " | " + seven);
			}
			System.out
					.println("Ingrese el link del canal al que pertenece este video");
			String linkC = sc.nextLine();
			rs = stmt.executeQuery("select * from canal where link_canal = '"
					+ linkC + "';");
			comp = rs.next();
			if (!comp) {
				System.out.print("Inserte el nombre del canal\n");
				toProcess = sc.nextLine();
				String nombreC = acceptable(toProcess);
				System.out
						.print("Inserte cuantas personas estan suscritas al canal\n"
								+ "");
				int personasSuscritasC = sc.nextInt();
				sc.nextLine();
				stmt.executeUpdate("insert into canal values('" + linkC + "','"
						+ nombreC + "','" + personasSuscritasC + "');");
				rs = stmt
						.executeQuery("select * from canal where link_canal = '"
								+ linkC + "';");
				System.out.println("Canal");
				System.out.println("Link | Nombre | Personas Suscritas");
				while (rs.next()) {
					String one = rs.getString("link_canal");
					String two = rs.getString("nombre_canal");
					String three = rs.getString("personas_suscritas_canal");
					System.out.println(one + " | " + two + " | " + three);
				}
			}
			stmt.executeUpdate("insert into propietario values('" + linkC
					+ "','" + link + "');");
			rs = stmt
					.executeQuery("select * from propietario where canal_link = '"
							+ linkC + "' and video_link = '" + link + "';");
			System.out.println("Propietario");
			System.out.println("Link Canal | Link Video");
			while (rs.next()) {
				String one = rs.getString("canal_link");
				String two = rs.getString("video_link");
				System.out.println(one + " | " + two);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static String acceptable(String s) {
		String answer = "";
		char[] word = s.toCharArray();
		for (int i = 0; i < word.length; i++) {
			if (word[i] == '\'') {
				answer += "\\'";
			} else {
				answer += word[i];
			}
		}
		return answer;
	}
}