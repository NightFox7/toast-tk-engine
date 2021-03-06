package com.synaptix.toast.dao.domain.impl.test.block;

import java.util.ArrayList;
import java.util.List;

import com.github.jmkgreen.morphia.annotations.Embedded;
import com.github.jmkgreen.morphia.annotations.Entity;
import com.github.jmkgreen.morphia.annotations.Index;
import com.github.jmkgreen.morphia.annotations.Indexes;
import com.synaptix.toast.core.report.TestResult;
import com.synaptix.toast.dao.domain.api.test.IRunnableTest;
import com.synaptix.toast.dao.domain.impl.common.BasicEntityBean;
import com.synaptix.toast.dao.domain.impl.repository.ReportHelper;

@Entity(value = "test")
@Indexes({
        @Index(value = "name, -runDateTime"), 
        @Index("runDateTime"), 
        @Index("isTemplate")
})
public class TestPage extends BasicEntityBean implements IRunnableTest, ITestPage {

    @Embedded
    private TestResult testResult;

    @Embedded
    private List<IBlock> blocks;

    private int technicalErrorNumber;

    private int testSuccessNumber;

    private int testFailureNumber;

    private String parsingErrorMessage;

    private long runDateTime;

    private long executionTime;

    private long previousExecutionTime;

    private boolean previousIsSuccess;

    private boolean isTemplate;

	private boolean isSuccess;

    public TestPage() {
    	this.blocks = new ArrayList<>();
    }

    @Override
	public int getTechnicalErrorNumber() {
        return technicalErrorNumber;
    }

    @Override
	public void setTechnicalErrorNumber(final int technicalErrorNumber) {
        this.technicalErrorNumber = technicalErrorNumber;
    }

    @Override
	public int getTestSuccessNumber() {
        return testSuccessNumber;
    }

    @Override
	public void setTestSuccessNumber(final int testSuccessNumber) {
        this.testSuccessNumber = testSuccessNumber;
    }

    @Override
	public int getTestFailureNumber() {
        return testFailureNumber;
    }

    @Override
	public void setTestFailureNumber(final int testFailureNumber) {
        this.testFailureNumber = testFailureNumber;
    }

    @Override
	public void addBlock(final IBlock testBlock) {
        blocks.add(testBlock);
    }

    @Override
	public String getParsingErrorMessage() {
        return parsingErrorMessage;
    }

    public void setParsingErrorMessage(final String parsingErrorMessage) {
        this.parsingErrorMessage = parsingErrorMessage;
    }

    @Override
    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(final long executionTime) {
        this.executionTime = executionTime;
    }

    @Override
    public TestResult getTestResult() {
        return this.testResult;
    }

    @Override
    public void setTestResult(final TestResult testResult) {
        this.testResult = testResult;
    }

    @Override
    public void startExecution() {
        this.runDateTime = System.currentTimeMillis();
    }

    @Override
    public void stopExecution() {
        this.executionTime = System.currentTimeMillis() - runDateTime;
        setIsSuccess(ReportHelper.isSuccess(this));
    }

    @Override
	public List<IBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(final List<IBlock> blocks) {
        this.blocks = blocks;
    }

    @Override
    public long getPreviousExecutionTime() {
        return previousExecutionTime;
    }

    @Override
    public void setPreviousExecutionTime(final long previousExecutionTime) {
        this.previousExecutionTime = previousExecutionTime;
    }

    @Override
    public boolean isPreviousIsSuccess() {
        return previousIsSuccess;
    }

    @Override
    public void setPreviousIsSuccess(final boolean previousIsSuccess) {
        this.previousIsSuccess = previousIsSuccess;
    }

    public void setIsTemplate(final boolean isTemplate) {
        this.isTemplate = isTemplate;
    }

    public boolean getIsTemplate() {
        return this.isTemplate;
    }

    @Override
    public String getBlockType() {
        return "testPageBlock";
    }

	@Override
	public long getStartDateTime() {
		return runDateTime;
	}

	@Override
	public int getHeaderSize() {
		return 0;
	}

	@Override
	public boolean isSuccess() {
		return this.isSuccess;
	}

    @Override
    public void setIsSuccess(final boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}