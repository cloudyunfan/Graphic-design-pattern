public class TextBuilder implements Builder {
	// 文档内容保存在该字段中
	private StringBuffer buffer = new StringBuffer();
	// 纯文本的标题
	@Override
	public void makeTitle(String title) {
		// 装饰线
		buffer.append("======================\n");
		// 为标题加【】
		buffer.append("【" + title + "】\n");
		// 换行
		buffer.append("\n");
	}
	// 纯文本的字符串
	@Override
	public void makeString(String str) {
		// 为字符串添加-
		buffer.append('-' + str + "\n");
		// 换行
		buffer.append("\n");
	}
	// 纯文本的条目
	@Override
	public void makeItems(String[] items) {
		for (int i = 0; i < items.length; i++) {
			// 为条目添加.
			buffer.append("   ." + items[i] + "\n");
		}
		// 换行
		buffer.append("\n");
	}
	// 完成文档
	@Override
	public void close() {
		// 装饰线
		buffer.append("======================\n");
	}
	// 完成的文档
	public String getResult() {
		// 将StringBuffer变换为String
		return buffer.toString();
	}
}