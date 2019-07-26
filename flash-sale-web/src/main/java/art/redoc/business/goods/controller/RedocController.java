package art.redoc.business.goods.controller;

import art.redoc.base.feign.SnowFlakeGeneratorApiFeign;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
public class RedocController {

    @Autowired
    private SnowFlakeGeneratorApiFeign snowFlakeGeneratorApiFeign;

    @GetMapping("/")
    public Long get() throws Exception {
        return snowFlakeGeneratorApiFeign.generator().getData();
    }

    public static void main(String[] args) {

//        final long bitVector = EnumUtils.generateBitVector(IpStateEnum.class, new IpStateEnum[]{IpStateEnum.WHITE, IpStateEnum.BLACK,
//                IpStateEnum.WHITE, IpStateEnum.WHITE});
//        System.out.println(bitVector);
//
//        final EnumSet<IpStateEnum> ipStateEnums = EnumUtils.processBitVector(IpStateEnum.class, Long.valueOf("3"));
//        System.out.println(ipStateEnums);
//
//        List<EnumSet<IpStateEnum>> ipStates = new ArrayList<>();
//        ipStates.add(ipStateEnums);
//        boolean isBlacklist = ipStates.stream().noneMatch(ipState -> ipState.contains(IpStateEnum.WHITE)) && ipStates.stream().anyMatch
//        (RedocController::isBlacklist);
//        System.out.println(isBlacklist);
        String content;
        try {
            final InputStream is = new FileInputStream("C:\\code\\other_code\\flashsale\\flash-sale-web\\src\\main\\java\\art\\redoc" +
                    "\\model\\Test.java");
            final ByteArrayOutputStream os = new ByteArrayOutputStream();
            IOUtils.copy(is, os);
            content = os.toString("UTF-8");
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

//        final Map<String, String> filterMap = new HashMap<String, String>();
//        filterMap.put("import javax\\.persistence.+\\s+", "");
//        filterMap.put("@Entity\\s+", "");
//        filterMap.put("@Table.+\\s+", "");
//        filterMap.put("@Lob\\s+", "");
//        filterMap.put("\\n\\s+.+serialVersionUID+.+\\n", "");
//        filterMap.put("\\n\\s+@Column.+", "");
//        filterMap.put("\\n\\s+@Enumerated.+", "");
//        filterMap.put("\\n\\s+@OneToOne.+", "");
//        filterMap.put("\\n\\s+@OneToMany.+", "");
//        filterMap.put("\\n\\s+@ManyToMany.+", "");
//        filterMap.put("\\n\\s+@ManyToOne.+", "");
//        filterMap.put("\\n\\s+@org.hibernate.annotations.Type.+", "");
//        filterMap.put("\\n\\s+@Table.+", "");
//        filterMap.put("\\n\\s+@Temporal.+", "");

//        filterMap.forEach((k,v)->{
//            content.replaceAll(k,v);
//        });
//
//        System.out.println(content.replaceAll(
//                "\\r\\n\\s+.+serialVersionUID+.+\\n?"
//                , ""));
//        content.replaceAll("\\r\\n\\s+.+serialVersionUID+.+\\r\\n", "");

//        System.out.println(content.replaceAll(
//                "\\r\\n\\s+private (?!String|Timestamp)+.+\\n?"
//                , ""));

//        System.out.println(content.split("\\r\\n"));
//            List<String> list = new ArrayList<String>(){
//                {
//                    add("1");
//                    add("2");
//                    add("3");
//                }
//            };
//        list.add(0,"a");
//        list.add(1,"b");
//        System.out.println(list);
//        System.out.println(StringUtils.capitalize("user"));

        List<List<Integer>> toBeRemoved = new ArrayList<List<Integer>>() {
            {
                add(new ArrayList<Integer>() {
                    {
                        add(24);
                        add(25);
                        add(26);
                    }
                });
                add(new ArrayList<Integer>() {
                    {
                        add(28);
                        add(29);
                        add(30);
                    }
                });
                add(new ArrayList<Integer>() {
                    {
                        add(32);
                        add(33);
                        add(34);
                    }
                });
            }
        };
        List<String> contents = new ArrayList<>(Arrays.asList(content.replaceAll("\\r", "").split("\\n")));
        final List<List<Integer>> collect =
                toBeRemoved.stream().sorted((v1, v2) -> v2.stream().min(Comparator.naturalOrder()).get().compareTo(v1.stream().min(Comparator.naturalOrder()).get())).collect(Collectors.toList());
        collect.forEach(x -> x.forEach(y -> contents.remove(y)));
//        System.out.println(toBeRemoved);
        String x = "import com.fasterxml.jackson.annotation.JsonIgnore;";
//        System.out.println(x.substring(x.lastIndexOf(".") + 1, x.indexOf(";")));
        System.out.println(Pattern.matches("\\s+private+.+;","    private String name;"));
    }

    public enum IpStateEnum {
        WHITE, BLACK
    }

    protected static boolean isBlacklist(EnumSet<IpStateEnum> ipState) {
        if (ipState.contains(IpStateEnum.WHITE)) {
            return false;
        }
        return ipState.contains(IpStateEnum.BLACK);
    }
}
