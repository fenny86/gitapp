package bean;

import java.io.InputStream;

public class photoBean {
	private int id;
	private InputStream photo1;


public photoBean(int id, InputStream photo1) {
	super();
	this.id = id;
	this.photo1 = photo1;
}

public photoBean( ) {

}



@Override
public String toString() {
	return "photoBean [id=" + id + ", photo1=" + photo1 + "]";
}

public InputStream getPhoto() {
	return photo1;
}

public void setPhoto(InputStream photo) {
	this.photo1 = photo;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

}
