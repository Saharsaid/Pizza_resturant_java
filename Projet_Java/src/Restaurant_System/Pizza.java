package Restaurant_System;
	public class Pizza {
		private int id_pizza;
		private String name;
		private double price;
		private int stock;
		
	    public Pizza(int id_pizza,String name, double price, int stock) {
	    	this.id_pizza=id_pizza;
	        this.name = name;
	        this.price = price;
	        this.stock = stock;
	    }
	    
	    public String getName() {
	        return name;
	    }
	    
	    public double getPrice() {
	        return price;
	    }

	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    
	    
		public void setId(int id_pizza) {
			this.id_pizza = id_pizza;
		}

		public int getId_pizza() {
			return id_pizza;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}
		public String toStringMenu() {
			return "| id : "+this.id_pizza+"        \n"
				 +"|-------------------------------|\n"
					+"| name : "+this.name+"           \n"
					+"| price : "+this.price/1000+"TND\n"
					+"|-------------------------------|\n";
		}
		public String toString() {
			return "|-------------------------------|\n"
					+"| Pizza id : "+this.id_pizza+"        \n"
				 +"|-------------------------------|\n"
					+"| name : "+this.name+"           \n"
					+"| price : "+this.price/1000+"TND\n"
					+"|-------------------------------|\n";
		}
		



	}

