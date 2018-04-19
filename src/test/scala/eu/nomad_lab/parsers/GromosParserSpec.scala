package eu.nomad_lab.parsers

import org.specs2.mutable.Specification

object GromosParserTests extends Specification {
  "GromosParserTest_1" >> {
    "[Peptide in Water with 2792 atoms] test with json-events" >> {
      ParserRun.parse(GromosParser, "parsers/gromos/test/examples/eq/eq_peptide_1.omd", "json-events") must_== ParseResult.ParseSuccess
    }
  }
  "GromosParserTest_2" >> {
    "[Peptide in Water with 2792 atoms] test with json" >> {
      ParserRun.parse(GromosParser, "parsers/gromos/test/examples/eq/eq_peptide_1.omd", "json") must_== ParseResult.ParseSuccess
    }
  }
}
