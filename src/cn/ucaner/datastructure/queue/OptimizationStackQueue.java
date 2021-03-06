/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.datastructure.queue;

import cn.ucaner.datastructure.stack.LinkedStack;

/**
 * Title: 使用两个栈模拟一个队列 Description: 其中一个栈专门用作入队(始终不执行出队操作)，另一个栈专门用作出队(始终不执行入队操作)
 * 此种解法相对于StackQueue性能要高不少，避免了反复“倒”栈，仅在需要时才“倒”一次！！！
 */
public class OptimizationStackQueue<E> {

	private LinkedStack<E> stack1; // 入队栈
	private LinkedStack<E> stack2; // 出队栈

	public OptimizationStackQueue() {

		stack1 = new LinkedStack<E>();
		stack2 = new LinkedStack<E>();
	}

	/**
	 * @description 添加元素到队尾,直接对stack1执行压栈操作。
	 * @param e
	 */
	public void put(E e) {
		stack1.push(e);
	}

	/**
	 * @description 删除队头并返回队头元素的值。先检查stack2是否为空：
	 *              若为空，先将stack1中的元素全部倒回stack2，再对stack2执行弹栈操作
	 *              否则，则直接对stack2执行弹栈操作
	 * @return
	 */
	public E pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop().getData());
			}
		}
		return stack2.pop().getData();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (!stack2.isEmpty()) {
			sb.append(stack2.toString());
		}
		return sb.append(
				new StringBuilder(stack1.toString()).reverse().toString())
				.toString();
	}
}
