public class Triple {
	private static Triple[] triples = {new Triple(), new Triple(), new Triple()};
	private Triple() {
	}
	public static Triple getInstance(int id) {
		return triples[id];
	}
}