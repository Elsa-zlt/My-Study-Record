#### [剑指 Offer II 006. 排序数组中两个数字之和](https://leetcode-cn.com/problems/kLl5u1/)

给定一个已按照 **升序排列**  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。

函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。

假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。

示例 1：

```
输入：numbers = [1,2,4,6,10], target = 8
输出：[1,3]
解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
```

示例 2：

```
输入：numbers = [2,3,4], target = 6
输出：[0,2]
```

示例 3：

```
输入：numbers = [-1,0], target = -1
输出：[0,1]
```


提示：

```
2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers 按 递增顺序 排列
-1000 <= target <= 1000
仅存在一个有效答案
```

```java
// 方法一：二分查找 
// 时间复杂度：O(nlogn)，其中 n是数组的长度。需要遍历数组一次确定第一个数，时间复杂度是O(n)，寻找第二个数/使用二分查找，时间复杂度是O(logn)，因此总时间复杂度是O(nlogn)。
class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int len = numbers.length;
    for(int i = 0; i < len; i++) {
      int low = i + 1, high = len - 1;
      while(low <= high) {
        int mid = (high - low) / 2 + low;
        if(numbers[mid] == target - numbers[i]) {
          return new int[]{i, mid};
        } else if(numbers[mid] > target - numbers[i]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }
    return new int[]{-1, -1};
  }
}

// 方法二：双指针
// 时间复杂度：O(n)，其中 nn 是数组的长度。两个指针移动的总次数最多为 n 次。
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while(low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                return new int[]{low, high};
            } else if(sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}
```

#### [剑指 Offer II 018. 有效的回文](https://leetcode-cn.com/problems/XltzEq/)

给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，**可以忽略字母的大小写**。

本题中，将空字符串定义为有效的 回文串 。

示例 1:

```
输入: s = "A man, a plan, a canal: Panama"
输出: true
解释："amanaplanacanalpanama" 是回文串
```

示例 2:

```
输入: s = "race a car"
输出: false
解释："raceacar" 不是回文串
```


提示：

```
1 <= s.length <= 2 * 105
字符串 s 由 ASCII 字符组成
```

```java
// 自己的答案
class Solution {
  private String str = "";

  public boolean check() {
    StringBuilder sBu = new StringBuilder(str);
    String ret = sBu.reverse().toString();
    return str.equals(ret);
  }

  public boolean isPalindrome(String s1) {
    s1 = s1.toLowerCase();
    char[] s = s1.toCharArray();
    int slen = s.length;
    for(int i = 0; i < slen; i++) {
      if((s[i] >= 'a' && s[i] <= 'z')||(s[i] >= '0' && s[i] <= '9')) {
        str += s[i];
      }
    }
    return check();
  }
}

// 方法一：筛选 + 判断
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }
}

// 方法二：在原字符串上直接判断
class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len - 1;
        while(left < right) {
            while(left<right&&!Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while(left<right&&!Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if(left < right) {
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
```

#### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例 1：

```
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
```

示例 2：

```
输入：n = 1
输出：["()"]
```


提示：

```
1 <= n <= 8
```

```java
// 回溯法
class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<String>();
    backtrack(ans, new StringBuilder(), 0, 0, n);
    return ans;
  }
  
  public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
    if(cur.length() == max * 2) {
      ans.add(cur.toString());
      return;
    }
    if(open < max) {
      cur.append('(');
      backtrack(ans, cur, open + 1, close, max);
      cur.deleteCharAt(cur.length() - 1);
    }
    if(close < open) {
      cur.append(')');
      backtrack(ans, cur, open, close + 1, max);
      cur.deleteCharAt(cur.length() - 1);
    }
  }
}
```

