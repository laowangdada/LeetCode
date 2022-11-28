/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class Trie_208 {
    /** Initialize your data structure here. */
    TreeNode root = new TreeNode();
    public Trie_208() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int index=0;
        TreeNode cur=this.root;
        for(int i=0;i<word.length(); i++){
            index=word.charAt(i) - 'a';
            if(cur.children[index]==null){
                cur.children[index]=new TreeNode();
            }
            cur=cur.children[index];
            if(i==word.length() - 1){
                cur.isWord=true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int index=0;
        TreeNode cur=this.root;
        for(int i=0;i<word.length(); i++){
            index=word.charAt(i) - 'a';
            if(cur.children[index]==null){
                return false;
            }else {
                cur=cur.children[index];
            }
        }
        if(cur.isWord)
            return true;
        else
            return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur=this.root;
        int index=0;
        for(int i=0;i<prefix.length(); i++){
            index=prefix.charAt(i) - 'a';
            if(cur.children[index]==null){
                return false;
            }else {
                cur=cur.children[index];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie_208 a=new Trie_208();
        a.insert("aaaa");
        System.out.println(a.search("aaa"));
    }
}
class TreeNode{
    public char val;
    public Boolean isWord=false;
    public TreeNode[] children = new TreeNode [26];
    TreeNode() {

    }
    TreeNode(char c){
        this.val = c;
        this.children[c-'a']=new TreeNode();
    }
}
