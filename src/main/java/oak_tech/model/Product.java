package oak_tech.model;

public class Product {
	private Long id;
	private String name;
	private String description;
	private float value;
	private boolean available;

	public Product(String name, String description, float value, boolean available) {
		super();
		this.name = name;
		this.description = description;
		this.value = value;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", value=" + value
				+ ", available=" + available + "]";
	}
}
