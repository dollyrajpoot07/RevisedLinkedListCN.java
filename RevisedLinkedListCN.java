import java.util.*;

 class Node<Generics> {
    Generics data;
    Node<Generics> next;
    public Node(Generics data) {
        this.data = data;
        next = null;
    }
}

public class RevisedLinkedListCN {
    public static Node<Integer> createLl() {
        Node<Integer> head = new Node<>(10);
        Node<Integer> n1 = new Node<>(20);
        Node<Integer> n2 = new Node<>(30);
        Node<Integer> tail = new Node<>(40);
        head.next = n1;
        n1.next = n2;
        n2.next = tail;
        tail.next = null;
        return n1;
    }
    
    public static void printLl(Node<Integer> head) {
        while(head != null) {
        System.out.println(head.data);
        head = head.next;
        }
    }
    public static void increment(Node<Integer> head) {
        head.data++;
    }
    
    public static int length(Node<Integer> head){
		Node<Integer> temporary = head;
        int count = 0;
        while(temporary != null) {
            count++;
            temporary = temporary.next;
        }
        return count;
	}
	
	public static void printIthNode(Node<Integer> head, int i){
		Node<Integer> temporary = head;
        int count = 0;
        if(temporary == null) {
           return;
        }
        while(temporary != null) {	
            if(count == i) {
                System.out.println("ith node is: " + temporary.data);
            }
            count++;
            temporary = temporary.next;
        }
	}
	
	public static Node<Integer> takeInput() {
        // Time complexity : O(n*n)
	    Scanner sc = new Scanner(System.in);
	    int data = sc.nextInt();
	    Node<Integer> head = null;
	    while(data != -1) {
            Node<Integer> curNode = new Node<Integer>(data);
	        if(head == null) {
                head = curNode;
	        } else {
                Node<Integer> tail = head;
	            while(tail.next != null) {
                    tail = tail.next;
	            }
	            tail.next = curNode;
	        }
	        data = sc.nextInt();
	    }
        sc.close();
	    return head;
	}

    public static Node<Integer> takeInputOptimized() {
        // Time complexity : O(n)
	    Scanner sc = new Scanner(System.in);
	    int data = sc.nextInt();
	    Node<Integer> head = null, tail = null;
	    while(data != -1) {
            Node<Integer> curNode = new Node<Integer>(data);
	        if(head == null) {
                head = curNode;
                tail = curNode;
	        } else {
                tail.next = curNode;
                tail = tail.next;
                // tail = curNode;
	        }
	        data = sc.nextInt();
	    }
        sc.close();
	    return head;
	}

    public static Node<Integer> insert(Node<Integer> head, int pos, int data){
		Node<Integer> nodeToBeInserted = new Node<>(data);
        if(pos == 0){
            nodeToBeInserted.next = head;
            return nodeToBeInserted;
        }
        else {
            int count = 0;
            Node<Integer> prev = head;
            while(count < pos - 1 && prev != null) {
                count++;
                prev = prev.next;
            }
            if(prev != null) {
                nodeToBeInserted.next = prev.next;
                prev.next = nodeToBeInserted;
            }
            return head;
        }
	}

    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
		if (pos < 0) {
            return head;
        } else if(pos == 0) {
            head = head.next;
        } else {
            Node<Integer> n = head;
            // int delNode = 0;
            for (int i = 0; i < pos - 1 && n != null; i++) {
                n = n.next;
            }
            if (n != null && n.next != null) {
                if (n.next != null) {
                    n.next = n.next.next;
                } else {
                    n.next = null;
                }
            }
        }
        return head;
    } 
///////////////////////////////////////////////
    public static int findNode(Node<Integer> head, int n) {
		Node<Integer> pos = head;
        int count = 0;
        if(head == null) {
            return -1;
        } else if(pos.data == n) {
            return 0;
        }
        Node<Integer> tail = head;
        while(tail != null) {
            if(tail.data == n) {
                return count;
            } else {
                count++;
                tail = tail.next;
            }
        }
        return -1;
	}

    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		int totalelements = 0;
		Node<Integer> count =head;
        if(head == null) {
            return null;
        } if(n == 0) {
            return count;
        } while(count != null) {
			totalelements++;
			count = count.next;
		}
		int sub = totalelements - n;
		Node<Integer> nh = head;
		int c = 0;
		while(c < sub) {
			c++;
			nh = nh.next;
		}
		Node<Integer> newhead = nh;
		Node<Integer> prev = newhead;
		while(prev.next != null) {
			prev = prev.next;
		}
		prev.next = head; 
		Node<Integer> br = head;
		int co = 0;
		while(co < sub - 1) {
			co++;
			br = br.next;
		}
		br.next = null;
		return newhead;
	}

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
		Node<Integer> temp = head;
		if(temp == null) {
			return null;
		} else if(temp.next == null) {
			return head;
		}
		while(temp != null && temp.next != null) {
			if((temp.data).equals(temp.next.data)) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return head;
	}

    public static void printReverse(Node<Integer> root) {
		// Node<Integer> temp = root;
        if(root == null) {
            return;
        }
        printReverse(root.next);
        System.out.print(root.data + " ");
	}

    public static boolean isPalindrome(Node<Integer> head) {
		Node<Integer> node = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (node != null) {
            arr.add(node.data);
            node = node.next;
        }
        int start = 0;
        int end = arr.size() - 1;
        while(start < end) {
            if (arr.get(start) != arr.get(end)) {
                return false;
            } else {
                start = start + 1;
                end = end - 1;
            }
        }
        return true;
	}

    public static void main(String[] args) {

// 		Node<Integer> n1 = new Node<>(10);
// 		System.out.println(n1.data);
// 		System.out.println(n1.next);
// 		System.out.println(n1);

        // Node<Integer> head = createLl();
        System.out.println("Enter input values: ");
        Node<Integer> head = takeInputOptimized();
        System.out.println("Increment kr diya ");
        increment(head);
        int res = length(head);
        System.out.println("size: " + res);
        printIthNode(head, 3);
        System.out.println("Inserting");
        insert(head, 3, 99);
        System.out.println("Deleting");
        deleteNode(head, 4);
        System.out.println("Finding a node");
        findNode(head, 99);
        System.out.println("Append Last N to First");
        appendLastNToFirst(head, 87);
        System.out.println("Eleminating duplicates node");
        removeDuplicates(head);
        System.out.println("Printing reverse Linked List");
        printReverse(head);
        System.out.println("Palindrome Linked List");
        isPalindrome(head);
        System.out.println("print linked list: ");
        printLl(head);

	}
}
