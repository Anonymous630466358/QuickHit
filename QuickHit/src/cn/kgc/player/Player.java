package cn.kgc.player;

import java.util.Scanner;

import cn.kgc.game.Game;

public class Player {
	private int levelNo;// ��ǰ�����
	private int currScore;// ��ǰ�������
	private long startTime;// ��ǰ����ʼʱ��
	private int elapsedTime;// ��ǰ��������ʱ��

	public Player() {
		super();
	}

	public Player(int levelNo, int currScore, long startTime, int elapsedTime) {
		super();
		this.levelNo = levelNo;
		this.currScore = currScore;
		this.startTime = startTime;
		this.elapsedTime = elapsedTime;
	}

	public int getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}

	public int getCurrScore() {
		return currScore;
	}

	public void setCurrScore(int currScore) {
		this.currScore = currScore;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public int getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	@Override
	public String toString() {
		return "Player [levelNo=" + levelNo + ", currScore=" + currScore + ", startTime=" + startTime + ", elapsedTime="
				+ elapsedTime + "]";
	}

	@SuppressWarnings({ "static-access", "resource" })
	public void play() {
		Game g = new Game(this);
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < g.getLevels().length; i++) {
			// ��ʼ�������
			levelNo += 1;
			// ��ʼ������
			currScore = 0;
			// ��ʼ��ʱ��
			startTime = System.currentTimeMillis();
			// ��ʼ������ʱ��
			elapsedTime = 0;
			for (int j = 0; j < g.getLevels()[this.levelNo - 1].getStrTimes(); j++) {
				String out = g.printStr();
				System.out.println(out);
				g.printResult(out, sc.next());
			}
		}
	}

	public static void main(String[] args) {
		Player p = new Player();
		p.play();
	}
}
