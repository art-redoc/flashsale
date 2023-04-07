package art.redoc.sourcegenerator;

import art.redoc.SourceGenerator;

import java.util.Arrays;

public class GeneratorStarter {
    public static void main(String[] args) throws ClassNotFoundException {
        SourceGenerator.generate("art.redoc.exam.model",
                new String[]{
                        "Exam"
//                        "Adventure",
//                        "AdventureEvent",
//                        "AdventureEventAreaColor",
//                        "AdventureEventDesc",
//                        "Attribute",
//                        "ChargeConfig",
//                        "Deposit",
//                        "Fee",
//                        "GeneMutate",
//                        "Genes",
//                        "Guard",
//                        "Pet",
//                        "PetAttribute",
//                        "PetCode",
//                        "PetTalk",
//                        "Praise",
//                        "SaleAuction",
//                        "Siring",
//                        "SiringAuction",
//                        "Treasure",
//                        "User",
//                        "UserWallet",
//                        "WalletAddress",
//                        "Withdraw",
                },
                "model",
                SourceGenerator.Output.FILE,
                true,
                SourceGenerator.IDType.LONG,
                null
//                Arrays.asList(SourceGenerator.OutputFileType.DTO)
        );
    }
}
