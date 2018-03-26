package FileSystem;

import java.util.ArrayList;

public abstract class Entry {
    //the base abstract class that a file or a directory will inherit from
    //actions for a file or directory:
    //delete an entry
    //be able to identify its parent

    protected Directory parent;
    protected String name;
    protected long timeCreated;

    public Entry(String name, Directory parent){
        this.parent = parent;
        this.name = name;
        this.timeCreated = System.currentTimeMillis();
    }

    public boolean delete(){
        if(this.parent == null){
            return false;
        }
        return parent.deleteEntry(this);
    }

    public abstract int size();

    public class File extends Entry{

        protected String content;
        protected int size;

        public File(String name, Directory parent, int size){
            super(name, parent);
            this.size = size;
        }

        public String getContent(){
            return this.content;
        }

        public int size(){
            return this.size;
        }
    }
    public class Directory extends Entry{

        protected ArrayList<Entry> content;

        public Directory(String name, Directory parent){
            super(name, parent);
            content = new ArrayList<Entry>();
        }

        public int size(){
            int size = 0;
            for (Entry e: content) {
                size += e.size();
            }
            return size;
        }

        public int numberOfFiles(){
            int count = 0;
            for (Entry e : content) {
                if(e instanceof File){
                    count ++;
                } else if (e instanceof Directory){
                    count ++;
                    count += ((Directory) e).numberOfFiles();
                }
            }
            return count;
        }

        public boolean addEntry(Entry e){
            return content.add(e);
        }

        public boolean deleteEntry(Entry e){
            return content.remove(e);
        }
    }
}
