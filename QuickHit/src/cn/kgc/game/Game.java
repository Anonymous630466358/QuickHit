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
	 * 级别号 levelNo 长度 strLength 次数限制 strTimes 时间限制 timeLimit 每级得分 perScore
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
	 * 输出字符串
	 * 
	 * @return 返回字符串用于和玩家输入比较
	 */
	public String printStr() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();
		int strLength = levels[player.getLevelNo()-1].getStrLength();
		// 通过循环生成要输出的字符串
		for (int i = 0; i < strLength; i++) {
			int rand = random.nextInt(strLength);// 产生随机数
			// 根据随机数拼接字符串
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
	 * 比较游戏输出out和玩家输入in，根据比较结果输出相应信息
	 * 
	 * @param out 游戏输出字符串
	 * @param in  玩家输入字符串
	 */
	public void printResult(String out, String in) {
		if (out.equals(in)) {
			player.setElapsedTime((int) ((System.currentTimeMillis() - player.getStartTime()) / 1000));
			if (player.getElapsedTime() > levels[player.getLevelNo()-1].getTimeLimit()) {
				System.out.println("操作超时，游戏结束！！！");
				System.exit(0);
			} else {
				player.setCurrScore(player.getCurrScore()+levels[player.getLevelNo()-1].getPerScore());
				System.out.println("输入正确，您的积分" + player.getCurrScore() + "，您的级别" + player.getLevelNo() + "，已用时间"
						+ player.getElapsedTime());
				if (player.getLevelNo() == levels.length
						&& player.getCurrScore() == levels[levels.length - 1].getPerScore()
								* levels[levels.length - 1].getStrTimes()) {
					System.out.println("恭喜，您已通关！！！");
					System.exit(0);
				}
			}
		} else {
			System.out.println("输入错误，游戏结束！！！");
			System.exit(0);
		}
	}

}
