
class TestStrings{
	public static void main(String[] args){
		String fileName = "example.doc";
		String fileName2 = "example.bak";
		boolean bo = fileName.equals(fileName2);
		System.out.println(bo);
        fileName = fileName.concat(".bak");
        System.out.println(fileName);
	}
}