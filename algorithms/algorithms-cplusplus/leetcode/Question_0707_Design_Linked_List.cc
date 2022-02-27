
class Node {
 public:
  int val;
  Node* next;
  Node(int val) {
      this->val=val;
      next=NULL;
  }
};

class MyLinkedList {
 public:
  MyLinkedList() {
  }
  
  int get(int index) {
    if(index >= size) {
      return -1;
    }
    Node *p = head->next;
    for (int i=0; i < index; i++) {
      p = p->next;
    }
    return p->val;
  }
  
  void addAtHead(int val) {
    Node *p = head->next;
    head->next = new Node(val);
    head->next->next = p;
    size++;
  }
  
  void addAtTail(int val) {
    Node *p = head;
    while (p->next) {
      p = p->next;
    }
    p->next = new Node(val);
    size++;
  }
  
  void addAtIndex(int index, int val) {
    if(index > size) {
      return;
    }
    Node* p = head;
    for (int i = 0; i < index; i++) {
      p = p->next;
    }
    Node *node = new Node(val);
    node->next = p->next;
    p->next = node;
    size++;
  }
  
  void deleteAtIndex(int index) {
    if(index >= size) {
      return;
    }
    Node *p = head;
    for (int i = 0; i < index; i++) {
      p = p->next;
    }
    Node *node = p ->next;
    p->next = p->next->next;
    size--;
    delete node;
  }

 private:
  int size=0;
  Node* head=new Node(0);
};
