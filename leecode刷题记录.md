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
// 时间复杂度：O(n)，其中 n 是数组的长度。两个指针移动的总次数最多为 n 次。
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

#### [26. 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。

由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。

将最终结果插入 nums 的前 k 个位置后返回 k 。

不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1：

```
输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
```

示例 2：

```
输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
```


提示：

```
0 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums 已按 升序 排列
```

```java
// 双指针
class Solution {
  public int removeDuplicates(int[] nums) {
    int nlen = nums.length;
    // 特判
    if(nums == null || nlen == 0) {
      return 0;
    }
    int p = 0;
    int q = 1;
    while(q < nlen) {
      if(nums[p] != nums[q]) {
        nums[p + 1] =nums[q];
        p++;
      }
      q++;
    }
    return p + 1;
  }
}
```

#### [剑指 Offer II 003. 前 n 个数字二进制中 1 的个数](https://leetcode-cn.com/problems/w3tCBm/)

给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。

 

示例 1:

```
输入: n = 2
输出: [0,1,1]
```

解释: 

```
0 --> 0
1 --> 1
2 --> 10
```

示例 2:

```
输入: n = 5
输出: [0,1,1,2,1,2]
```

解释:

```
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
```


说明 :

```
0 <= n <= 105
```


进阶:

给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？
要求算法的空间复杂度为 O(n) 。
你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。

```java
// 自己的答案
class Solution {
  private int[] res;
  public int[] countBits(int n) {
    // 初始化
    res = new int[n + 1];    
    res[0] = 0;
    int now;
    for(int i = 0; i <= n; i++) {
      int record = i;
      int count = 0;
      while(record != 0) {
        now = record % 2;
        if(now == 1) {
          // 这个数字加1
          count++;
        }
        record = (int)(record / 2);
      }
      res[i] = count;
    }
    return res;
  }
}

// 方法一：Brian Kernighan 算法
class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }
    public int countOnes(int x) {
        int ones = 0;
        while(x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}

// 方法三：动态规划——最低有效位
class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
```

#### [剑指 Offer II 011. 0 和 1 个数相同的子数组](https://leetcode-cn.com/problems/A1NYOS/)

给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。

示例 1：

```
输入: nums = [0,1]
输出: 2
说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
```

示例 2：

```
输入: nums = [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
```


提示：

```
1 <= nums.length <= 105
nums[i] 不是 0 就是 1
```

```java
// 方法一：前缀和 + 哈希表
class Solution {
  public int findMaxLength(int[] nums) {
    int maxLength = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int counter = 0;
    map.put(counter, - 1);
    int len = nums.length;
    for(int i = 0; i < len; i++) {
      int num = nums[i];
      if(num == 1) {
        counter++;
      } else {
        counter--;
      }
      if(map.containsKey(counter)) {
        int prevIndex = map.get(counter);
        maxLength = Math.max(maxLength, i - prevIndex);
      } else {
        map.put(counter, i);
      }
    }
    return maxLength;
  }
}
```

#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

示例 1：

```
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```

示例 2：

```
输入：nums = [3,2,4], target = 6
输出：[1,2]
```

示例 3：

```
输入：nums = [3,3], target = 6
输出：[0,1]
```


提示：

```
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
```

```java
// 自己的答案
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 2};
    }
}

// 方法二：哈希表
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++) {
            if(hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[]{0, 2};
    }
}
```

#### [704. 二分查找](https://leetcode-cn.com/problems/binary-search/)

给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


示例 1:

```
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```

示例 2:

```
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
```


提示：

```
你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间。
```

```java
// 自己的答案
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(nums[0] == target) {
            return 0;
        }
        for(int i = 0; i < len; i++) {
            int low = i + 1, high = len - 1;
            while(low <= high) {
                int mid = (high - low) / 2 + low;
                if(nums[mid] == target) {
                    return mid;
                } else if(nums[mid] > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return -1;
    }
}
```

#### [278. 第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version/)

你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。


示例 1：

```
输入：n = 5, bad = 4
输出：4
```

解释：

```
调用 isBadVersion(3) -> false 
调用 isBadVersion(5) -> true 
调用 isBadVersion(4) -> true
所以，4 是第一个错误的版本。
```

示例 2：

```
输入：n = 1, bad = 1
输出：1
```


提示：

```
1 <= bad <= n <= 231 - 1
```

```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
// 二分查找
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        // 循环直至区间左右端点相同
        while(left < right) {
            // 防止计算时溢出
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                // 答案在区间[mid + 1, right]中
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 此时left == right，区间缩为一个点，即为答案
        return left;
    }
}
```

#### [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。

示例 1:

```
输入: nums = [1,3,5,6], target = 5
输出: 2
```

示例 2:

```
输入: nums = [1,3,5,6], target = 2
输出: 1
```

示例 3:

```
输入: nums = [1,3,5,6], target = 7
输出: 4
```


提示:

```
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 为 无重复元素 的 升序 排列数组
-104 <= target <= 104
```

```java
// 自己的答案
class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // System.out.println(len);
        if(nums[0] == target && len == 1) {
            return 0;
        }
        int low = 1, high = len - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] >= target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        for(int i = len - 1; i >= 0; i--) {
            if(nums[i] < target) {
                return i + 1;
            }
        }
        return 0;
    }
}
```

#### [剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：

```
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

示例 2：

```
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
```

提示：

```
1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用
```

```java
class CQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            in2out();
        }
        return outStack.pop();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}


/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
```

#### [剑指 Offer 30. 包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

示例:

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```


提示：

```
各函数的调用总次数不超过 20000 次
```

```java
class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
```

#### [977. 有序数组的平方](https://leetcode-cn.com/problems/squares-of-a-sorted-array/)

给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 

示例 1：

```
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
```

示例 2：

```
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
```


提示：

```
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序
```


进阶：

```
请你设计时间复杂度为 O(n) 的算法解决本问题
```

```java
// 自己的答案
class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] tmp = new int[len];
        if(nums[0] >= 0) {
            for(int i = 0; i < len; i++) {
                tmp[i] = nums[i] * nums[i];
            }
            return tmp;
        }
        for(int i = 0; i < len; i++) {
            tmp[i] = nums[i] * nums[i];
        }
        Arrays.sort(tmp);
        return tmp;
    }
}

// 方法二：双指针
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for(int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }
        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while(i >= 0 || j < n) {
            if(i < 0) {
                ans[index] = nums[j] * nums[j];
                j++;
            } else if(j == n) {
                ans[index] = nums[i] * nums[i];
                i--;
            } else if(nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                i--;
            } else {
                ans[index] = nums[j] * nums[j];
                j++;
            }
            index++;
        }
        return ans;
    }
}
```

#### [189. 轮转数组](https://leetcode-cn.com/problems/rotate-array/)

给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

示例 1:

```
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]
```

示例 2:

```
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释: 
向右轮转 1 步: [99,-1,-100,3]
向右轮转 2 步: [3,99,-1,-100]
```


提示：

```
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
```


进阶：

```
尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
```

```java
// 自己的答案
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        // System.out.println(len);
        int[] tmp = new int[len];
        int t;
        for(int i = 0; i < len; i++) {
            if(i + k >= len) {
                tmp[(i + k - len) % len] = nums[i];
            } else {
                tmp[(i + k) % len] = nums[i];
            }
        }
        for(int i = 0; i < len; i++) {
            nums[i] = tmp[i];
        }
    }
}

// 方法二：环状替换
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for(int start = 0; start < count; start++) {
            int current = start;
            int prev = nums[start];
            do{
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while(start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
     }
}
```

#### [剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

```
输入：head = [1,3,2]
输出：[2,3,1]
```


限制：

```
0 <= 链表长度 <= 10000
```

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 自己的答案
class Solution {
    public int[] reversePrint(ListNode head) {
        ArrayList temp = new ArrayList<>();
        // do {
        //     head = head.next;
        //     temp.add(head.val);
        //     System.out.println(head.val);
        // } while(head.next != null);
        for(;head != null; head = head.next) {
            temp.add(head.val);
            // System.out.println(head.val);
        }
        int len = temp.size();
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            res[i] = (int)temp.get(len - i - 1);
        }
        return res;
    }
}
```

#### [剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

示例:

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```


限制：

```
0 <= 节点个数 <= 5000
```

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 方法一：迭代
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// 方法二：递归
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead =reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
```

#### [剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

```
输入：s = "We are happy."
输出："We%20are%20happy."
```


限制：

```
0 <= s 的长度 <= 10000
```

```java
// 自己的代码
class Solution {
    public String replaceSpace(String s) {
        int len = s.length();
        // System.out.println(len);
        // System.out.println(s.charAt(1));
        String temp = new String();
        for(int i = 0; i < len; i++) {
            if((char)s.charAt(i) == ' ') {
                temp += "%20";
            } else {
                temp += s.charAt(i);
            }
        }
        return temp;
    }
}

// 方法一：字符数组
class Solution {
    public String replaceSpace(String s) {
        int len = s.length();
        char[] array = new char[len * 3];
        int size = 0;
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0 ,size);
        return newStr;
    }
}
```

#### [剑指 Offer 58 - II. 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

示例 1：

```
输入: s = "abcdefg", k = 2
输出: "cdefgab"
```

示例 2：

```
输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
```


限制：

```
1 <= k < s.length <= 10000
```

```java
// 自己的答案
class Solution {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        n = n % len;
        String temp = "";
        for(int i = 0; i < len; i++) {
            if(i + n < len) {
                temp += s.charAt(i + n);
            } else {
                temp += s.charAt(i + n - len);
            }
        }
        return temp;
    }
}

// 方法一：字符串切片
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}

// 方法二：列表遍历拼接
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}
```

#### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。

示例 1:

```
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
```

示例 2:

```
输入: nums = [0]
输出: [0]
```


提示:

```
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
```

```java
// 自己的答案
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        // System.out.println(len);
        int[] temp = new int[len];
        for(int i = 0 , j = 0, k = 0; i < len; i++) {
            if(nums[i] == 0) {
                temp[len - 1 - j] = nums[i];
                j++;
            } else {
                temp[k] = nums[i];
                k++;
            }
        }
        for(int i = 0; i < len; i++) {
            nums[i] = temp[i];
        }
    }
}

// 方法一：双指针
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length, left = 0, right = 0;
        while(right < len) {
            if(nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
```

#### [167. 两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。

以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。

你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

你所设计的解决方案必须只使用常量级的额外空间。


示例 1：

```
输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
```

示例 2：

```
输入：numbers = [2,3,4], target = 6
输出：[1,3]
解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
```

示例 3：

```
输入：numbers = [-1,0], target = -1
输出：[1,2]
解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
```


提示：

```
2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers 按 非递减顺序 排列
-1000 <= target <= 1000
仅存在一个有效答案
```

```java
// 自己的答案(二分)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for(int i = 0; i < len; i++) {
            int low = i + 1, high = len - 1;
            while(low <= high) {
                int mid = (high - low) / 2 + low;
                if(numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
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
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int low = 0, high = len - 1;
        while(low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                return new int[]{low + 1, high + 1};
            } else if(sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[] {-1, -1};
    }
}
```

