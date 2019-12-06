import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.math.*;

public class Huffman {
    public static void main(String[] args) {
        // String inputUrl = "916ca1b9-0b9b-44fe-abd1-2d21675e3e6b?Files[0]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Ffb609ce5-abfe-48bf-b6a5-bd7398b164be&Files[1]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F39336ccd-fc31-4a9c-b4f6-e40cee67b748&bRefDownloads=false&bDownloadDerivedFiles=true&commonPath=DownloadCheck&commonParentId=916ca1b9-0b9b-44fe-abd1-2d21675e3e6b";
        String inputUrl = "3ae80d73-0f04-455c-a9c4-1abd298c3ce7?Files[0]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F607ef42a-77d9-493d-8093-0c9e26a989de&Files[1]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F3f235428-2f94-4528-b410-929379e30af0&Files[2]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F8b6feeb6-d898-46e7-bcef-a2c21c5c1360&Files[3]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fb44c02a2-9047-409b-9fd7-11dc9e2045e0&Files[4]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F8166a7d2-8a7b-4e3a-acaf-092e9a7b5b2b&Files[5]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fb82b0dfe-b31d-42b8-9822-6159ec7f8036&Files[6]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F392dce78-87e1-424b-b125-72e33052a3df&Files[7]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fbcdaa87c-4b40-4988-9b33-9d3c2bc34857&Files[8]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fac3693d5-b06c-4831-992a-4a5db720c49d&Files[9]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fadecedd1-e1b5-414c-b0a1-47515bc4c05d&Files[10]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F55494da4-87c2-4b39-abe2-acb60c3f6fec&Files[11]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F09a22c17-765f-4d05-bc5b-59b3b44a5f9b&Files[12]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fc11e1b66-0089-49a4-887f-a85396c55dcf&Files[13]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F1507512a-e071-4ad1-b234-1a64cf735b32&Files[14]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F92d97e84-6250-4434-83d3-001a9d227ff1&Files[15]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F11efc1e8-9b55-4f3c-bc39-44bdce4f5a0e&Files[16]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F2f97712b-d104-4efa-b4c1-384f45e821fd&Files[17]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Faab8520b-b932-4cf0-b346-94cc9ad4cb89&Files[18]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F728bc255-3af9-4397-85bb-6e1cc2a05a88&Files[19]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F5f136ae3-4ad2-4f29-a5ab-90322b718369&Files[20]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Febdab354-e1e3-473e-acc3-f2ed763f5057&Files[21]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F40a3b104-23ac-46f1-9ffb-1d182ca189fd&Files[22]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F06e93754-f1a2-4624-9e70-1a68fe3701da&Files[23]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F6de2c89f-258a-428d-8376-a9b091ce4d69&Files[24]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F144fac4a-588f-4dd9-bd65-3f0165144d73&Files[25]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F772ba11e-c7dd-4353-a4dc-ce02977be005&Files[26]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fc8d006ee-cc04-465b-a3bf-c686ec66a4ea&Files[27]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F3b11da47-2c16-49b6-8a4f-16727c8e4037&Files[28]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fb26c3203-b426-4d2c-8024-9e891a51f90f&Files[29]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F6c6b5d14-7495-436f-a824-056d3ce444aa&Files[30]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fdc1539d1-6dab-4ab8-b6f9-88852830bd31&Files[31]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fe5ab7fd4-b515-45ed-81b6-5107daf05844&Files[32]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fe11dd042-0e3f-4177-b646-349f3fe45664&Files[33]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fac156cd0-069c-437f-8d4d-47d51a47d1e5&Files[34]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F17055dde-e18b-42d3-9885-33696b1d2b33&Files[35]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F2a62dd54-a267-4d8f-a8e2-2980daad3106&Files[36]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F0aabdfc6-df29-4d5a-9bd0-a6353e292b86&Files[37]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2Fa5bfd1f6-b947-42dc-a14c-c92119b3e22d&Files[38]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Adocumentmanagement%2FDocumentRevision%3Aid%2F4e3e59bb-592a-4534-a923-1e9edfc6306c&CompIds[0]=urn%3Asiemens%3Acollabhub%3A%3A86eec971f4f343ffb150dd3047015b1f%3Amcad%2FDesignRevision%3Aid%2F62dfe1ee-37f1-49ca-9efb-a95ca3110797&bRefDownloads=false&bDownloadDerivedFiles=true&commonPath=Draft%20Files&commonParentId=3ae80d73-0f04-455c-a9c4-1abd298c3ce7&collabSpaceId=86eec971f4f343ffb150dd3047015b1f";
        // String inputUrl = "ABA11$A";
        Map<Character, Integer> frequencyMap = getFrequency(inputUrl);
        System.out.println("************");
        printFreq(frequencyMap);
        List<Node> frequencyList = getUnOrderedNodesList(frequencyMap);
        generateHuffmanTree(frequencyList);
        Map<Character, String> hcodeMap = new HashMap<>();
        getHuffManCode(frequencyList.get(0),  hcodeMap, "");
        System.out.println("************");
        printMap(hcodeMap);
        String binaryEncodedString = generateEncodedString(inputUrl, hcodeMap);
        System.out.println("************");
        System.out.println(binaryEncodedString);
        String hexadecimalEncodedData = getHexadecimalEncoding(binaryEncodedString);
        System.out.println("************");
        System.out.println(hexadecimalEncodedData);
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
    public static String generateEncodedString(String referenceString, Map<Character, String> hcodeMap) {
        String result = "";
        int len = referenceString.length();
        for(int i = 0;i<len;i++) {
            Character refChar = referenceString.charAt(i);
            String code = hcodeMap.get(refChar);
            result += code;
        }
        return result;
    }
    public static String getHexadecimalEncoding(String binaryString) {
        // BigInteger b = new BigInteger(binaryString, 2);
        // return b.toString(16);
		int size = 5;
        String[] tokens = binaryString.split("(?<=\\G.{" + size + "})");
        int count = tokens.length;
        String result = "";
        for(int i = 0;i<count;i++) {
            result += getCustomCharEncoding(tokens[i]);
        }
        return result;
    }
    public static String getCustomCharEncoding(String code) {
        String result = "";
        switch (code) {
            case "00000":
                result = "0";
                break;
            case "00001":
                result = "1";
                break;
            case "00011":
                result = "2";
                break;
            case "00100":
                result = "3";
                break;
            case "00101":
                result = "4";
                break;
            case "00110":
                result = "5";
                break;
            case "00111":
                result = "6";
                break;
            case "01000":
                result = "7";
                break;
            case "01001":
                result = "8";
                break;
            case "01010":
                result = "9";
                break;
            case "01011":
                result = "a";
                break;
            case "01100":
                result = "b";
                break;
            case "01101":
                result = "c";
                break;
            case "01110":
                result = "d";
                break;
            case "01111":
                result = "e";
                break;
            case "10000":
                result = "f";
                break;
            case "10001":
                result = "g";
                break;
            case "10010":
                result = "h";
                break;
            case "10011":
                result = "i";
                break;
            case "10100":
                result = "j";
                break;
            case "10101":
                result = "k";
                break;
            case "10110":
                result = "l";
                break;
            case "10111":
                result = "m";
                break;
            case "11000":
                result = "n";
                break;
            case "11001":
                result = "o";
                break;
            case "11010":
                result = "p";
                break;
            case "11011":
                result = "q";
                break;
            case "11100":
                result = "r";
                break;
            case "11101":
                result = "s";
                break;
            case "11110":
                result = "t";
                break;
            case "11111":
                result = "u";
                break;
            default:
                break;
        }
        return result;
    }
}