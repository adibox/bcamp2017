package curs.interfaces;

public interface BookInterface {
	public Long getId();


	public String getTitle();

	public void setTitle(String title);

	public String getAuthor();

	public void setAuthor(String author);

	public Integer getAvailableCount();

	public void setAvailableCount(Integer available);

	public Integer getSellCount();

	public void setSellCount(Integer booked);

}
