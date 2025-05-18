package data;

public class KindOfClothingFactory {
	
	public Receipt createReceiptByClothingKind(String kind) {
		
		if (kind == "Coat") {
			return new Receipt(kind);
		}
		else if ( kind == "Skirt") {
			return new Receipt(kind);
		}
		else if ( kind == "Shirt") {
			return new Receipt(kind);
		}
		else if ( kind == "Trouser") {
			return new Receipt(kind);
		}
		else {
			return null;
		}

	}

}
