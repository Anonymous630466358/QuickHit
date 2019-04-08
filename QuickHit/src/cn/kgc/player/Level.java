package cn.kgc.player;

public class Level {
	private int levelNo;// �����
	private int strLength;// ÿһ�������Ӧ���ַ�������
	private int strTimes;// ÿ������Ĵ�������
	private int timeLimit;// ÿ������ʱ������
	private int perScore;// ÿ��������ȷ����һ�εķ���

	public Level() {
		super();
	}

	public Level(int levelNo, int strLength, int strTimes, int timeLimit, int perScore) {
		super();
		this.levelNo = levelNo;
		this.strLength = strLength;
		this.strTimes = strTimes;
		this.timeLimit = timeLimit;
		this.perScore = perScore;
	}

	public int getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}

	public int getStrLength() {
		return strLength;
	}

	public void setStrLength(int strLength) {
		this.strLength = strLength;
	}

	public int getStrTimes() {
		return strTimes;
	}

	public void setStrTimes(int strTimes) {
		this.strTimes = strTimes;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public int getPerScore() {
		return perScore;
	}

	public void setPerScore(int perScore) {
		this.perScore = perScore;
	}


}
