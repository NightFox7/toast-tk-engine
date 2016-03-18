package com.synaptix.toast.dao.domain.impl.test.block;

import java.util.ArrayList;
import java.util.List;

import com.github.jmkgreen.morphia.annotations.Embedded;

@Embedded
public class CommentBlock implements IBlock {

	private List<String> lines;

	public CommentBlock() {
		this.lines = new ArrayList<>();
	}

	public void addLine(final String line) {
		lines.add(line);
	}

	public List<String> getLines() {
		return lines;
	}

	public void setLines(final List<String> lines) {
		this.lines = lines;
	}

	@Override
	public String getBlockType() {
		return "comment";
	}

	@Override
	public int getHeaderSize() {
		return 0;
	}
}