import java.util.Objects;

public class SessionList {
    private SessionList next;
    private Session data;
    public SessionList(Session data, SessionList next){
        this.data = data;
        this.next = next;
    }
    public Session append(Session data){
        checkInputs(data);
        if(this.data == null){
            this.data = data;
            return data;
        }
        SessionList currentNode = this;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new SessionList(data, null);
        return data;
    }

    public boolean isEmpty(){
        return(this.data==null);
    }
    private void checkInputs(Session data){
        if(this.data != null && idIndex(data.id())!=-1){
            throw new IllegalArgumentException("ID already in use");
        }
        if(data.id()<0){
            throw new IllegalArgumentException("ID may not be negative");
        }
        if(data.maxParticipants()<1){
            throw new IllegalArgumentException("Max Capacity Must be 1 or greater");
        }
    }

    public int len(){
        SessionList currentNode = this;
        int len = 0;
        while(currentNode != null){
            currentNode = currentNode.next;
            len++;
        }
        return len;
    }
    public Session getSession(int index){
        if(index>=this.len() || index < 0){
            throw new IndexOutOfBoundsException();
        }
        SessionList currentNode = this;
        for(int i = 0; i<index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }
    public Session removeSession(int id){
        int indexToRemove = idIndex(id);
        if(indexToRemove == -1){
            return null;
        }
        Session removedData = this.getSession(0);
        if(indexToRemove == 0){
            if(this.next == null){
                removedData = this.data;
                this.data = null;
            } else {
                removedData = this.data;
                this.data = this.next.data;
                this.next = this.next.next;
            }
            return removedData;
        }
        SessionList currentNode = this;
        for(int i = 0; i < indexToRemove-1; i++){
            currentNode = currentNode.next;
        }
        SessionList removedSession = currentNode.next;
        currentNode.next = currentNode.next.next;
        return removedSession.data;
    }
    public int idIndex(int id){
        SessionList currentNode = this;
        for(int i = 0; i<this.len(); i++){
            if(id == currentNode.data.id()){
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }
    public boolean replace(int index, Session newSession){
        SessionList currentNode = this;
        if(index>=this.len() || index < 0){
            throw new IndexOutOfBoundsException();
        }
        for(int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        currentNode.data = newSession;
        return true;
    }

    public SessionList searchByMentor(String mentorName){
        int length = this.len();
        SessionList output = new SessionList(null, null);
        SessionList currentNode = this;
        for(int i = 0; i<length; i++){
            if(Objects.equals(currentNode.data.mentor(), mentorName)){
                output.append(currentNode.data);
            }
            currentNode = currentNode.next;
        }
        return output;
    }


}
