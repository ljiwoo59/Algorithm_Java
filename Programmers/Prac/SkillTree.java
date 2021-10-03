import java.util.*;

// 프로그래머스 Summer/Winter Coding(~2018) > 스킬트리

public class SkillTree {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		int result = Solution(skill, skill_trees);
		
		System.out.println(result);
	}

	private static int Solution(String skill, String[] skill_trees) {
		int result = 0;
		String pattern = "[^" + skill + "]";
		next: for (String s : skill_trees) {
			String res = s.replaceAll(pattern, "");
			
			for (int i = 0; i < res.length(); i++) {
				if (res.charAt(i) != skill.charAt(i)) continue next;
			}
			
			result++;
		}
		return result;
	}

}
