package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name="friend_nick_name",joinColumns = @JoinColumn(name="friend_id"))
	@Column(name="nick_name")
	Set<String> nickName = new HashSet<>();

	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Friend(String name, Set<String> nickName) {
		super();
		this.name = name;
		this.nickName = nickName;
	}

	public Set<String> getNickName() {
		return nickName;
	}

	public void setNickName(Set<String> nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
	
	
	
	
}
