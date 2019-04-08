package cn.kgc.game;

import java.nio.Buffer;
import java.nio.CharBuffer;
import java.util.Random;

import cn.kgc.player.Level;
import cn.kgc.player.Player;

@SuppressWarnings("unused")
public class Game {
	private Player player = new Player();
	private static Level[] levels = new Level[6];

	public static Level[] getLevels() {
		return levels;
	}

	public Game() {
		super();
	}

	public Game(Player player) {
		super();
		this.player = player;
	}

	/**
	 * ����� levelNo ���� strLength �������� strTimes ʱ������ timeLimit ÿ���÷� perScore
	 */
	static {
		levels[0] = new Level(1, 2, 10, 30, 1);
		levels[1] = new Level(2, 3, 9, 50, 2);
		levels[2] = new Level(3, 4, 8, 100, 5);
		levels[3] = new Level(4, 5, 7, 200, 8);
		levels[4] = new Level(5, 6, 6, 200, 10);
		levels[5] = new Level(6, 7, 5, 200, 15);
	}

	/**
	 * ����ַ���
	 * 
	 * @return �����ַ������ں��������Ƚ�
	 */
	public String printStr() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		int strLength = levels[player.getLevelNo()-1].getStrLength();
		// ͨ��ѭ������Ҫ������ַ���
		for (int i = 0; i < strLength; i++) {
			int rand = random.nextInt(strLength);// ���������
			// ���������ƴ���ַ���
			switch (rand) {
			case 0:
				buffer.append("<");
				break;

			case 1:
				buffer.append(">");
				break;

			case 2:
				buffer.append("*");
				break;

			case 3:
				buffer.append("$");
				break;
			case 4:
				buffer.append("[");
				break;

			case 5:
				buffer.append("]");
				break;

			case 6:
				buffer.append("&");
				break;

			}
		}
		return buffer.toString();

	}

	/**
	 * �Ƚ���Ϸ���out���������in�����ݱȽϽ�������Ӧ��Ϣ
	 * 
	 * @param out ��Ϸ����ַ���
	 * @param in  ��������ַ���
	 */
	public void printResult(String out, String in) {
		if (out.equals(in)) {
			player.setElapsedTime((int) ((System.currentTimeMillis() - player.getStartTime()) / 1000));
			if (player.getElapsedTime() > levels[player.getLevelNo()-1].getTimeLimit()) {
				System.out.println("������ʱ����Ϸ����������");
				System.exit(0);
			} else {
				player.setCurrScore(player.getCurrScore()+levels[player.getLevelNo()-1].getPerScore());
				System.out.println("������ȷ�����Ļ���" + player.getCurrScore() + "�����ļ���" + player.getLevelNo() + "������ʱ��"
						+ player.getElapsedTime());
				if (player.getLevelNo() == levels.length
						&& player.getCurrScore() == levels[levels.length - 1].getPerScore()
								* levels[levels.length - 1].getStrTimes()) {
					System.out.println("��ϲ������ͨ�أ�����");
					System.exit(0);
				}
			}
		} else {
			System.out.println("���������Ϸ����������");
			System.exit(0);
		}
	}

}
