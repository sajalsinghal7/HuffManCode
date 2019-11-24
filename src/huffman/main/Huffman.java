import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Huffman {
    public static void main(String[] args) {
        String inputUrl = "916ca1b9-0b9b-44fe-abd1-2d21675e3e6b?Files[0]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Ffb609ce5-abfe-48bf-b6a5-bd7398b164be&Files[1]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F39336ccd-fc31-4a9c-b4f6-e40cee67b748&bRefDownloads=false&bDownloadDerivedFiles=true&commonPath=DownloadCheck&commonParentId=916ca1b9-0b9b-44fe-abd1-2d21675e3e6b";
        Map<Character, Integer> frequencyMap = getFrequency(inputUrl);
        System.out.println("************");
        printFreq(frequencyMap);
        List<Node> frequencyList = getUnOrderedNodesList(frequencyMap);
        generateHuffmanTree(frequencyList);
        Map<Character, String> hcodeMap = new HashMap<>();
        getHuffManCode(frequencyList.get(0),  hcodeMap, "");
        System.out.println("************");
        printMap(hcodeMap);
    }
    // Step1 - Generate Frequency MAP
    public static Map<Character, Integer> getFrequency(String input) {
        int len = input.length();
        Map<Character, Integer> res = new HashMap<>();
        for(int i = 0; i<len; i++) {
            Character ref = input.charAt(i);
            if(res.containsKey(ref)) {
                res.put(ref, res.get(ref) + 1);
            } else {
                res.put(ref, 1);
            }
        }
        return res;
    }
    // Strp2 -  
    public static List<Node> getUnOrderedNodesList(Map<Character, Integer> freq) {
        Iterator<Map.Entry<Character, Integer>> itr =  freq.entrySet().iterator();
        List<Node> nodeList = new LinkedList<Node>();
        while(itr.hasNext()) {
            Map.Entry<Character, Integer> entry = itr.next();
            Node newObj = new Node();
            newObj.weight = entry.getValue();
            newObj.ref = entry.getKey();
            nodeList.add(newObj);
        }
        return nodeList;
    }
    public static void generateHuffmanTree(List<Node> freqList) {
        if(freqList.size()>1) {
            Collections.sort(freqList, new NodeComparator());
            Node parent = new Node();
            parent.weight = freqList.get(0).weight + freqList.get(1).weight;
            parent.left = freqList.get(0);
            parent.right = freqList.get(1);
            freqList.remove(freqList.get(0));
            freqList.remove(freqList.get(0));
            freqList.add(parent);
            generateHuffmanTree(freqList);
        }
        return;
    }
    public static void getHuffManCode(Node head, Map<Character, String> hcodeMap, String code) {
        if(head == null) {
            return;
        }
        if(head.ref != null) {
            hcodeMap.put(head.ref, code);
        }
        getHuffManCode(head.left, hcodeMap, code + "0");
        getHuffManCode(head.right, hcodeMap, code + "1");
    }
    public static void printMap(Map<Character, String> hcodeMap) {
        Iterator<Map.Entry<Character, String>> itr = hcodeMap.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Character, String> entry = itr.next();
            System.out.println(entry.getKey() + "\t--\t" + entry.getValue());
        }
    }
    public static void printFreq(Map<Character, Integer> hcodeMap) {
        Iterator<Map.Entry<Character, Integer>> itr = hcodeMap.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Character, Integer> entry = itr.next();
            System.out.println(entry.getKey() + "\t--\t" + entry.getValue());
        }
    }
}