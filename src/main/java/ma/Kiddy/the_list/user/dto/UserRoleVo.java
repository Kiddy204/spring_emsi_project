package ma.Kiddy.the_list.user.dto;

public class UserRoleVo {
	private Long _id;
	private String name;
	
	//Constructors
	
	public UserRoleVo(Long _id, String name) {
		super();
		this._id = _id;
		this.name = name;
	}

	public UserRoleVo() {
		super();
	}


	
	//Getters and Setters 

	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	

}
