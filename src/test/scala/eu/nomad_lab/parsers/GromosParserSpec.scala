package eu.nomad_lab.parsers

import org.specs2.mutable.Specification

object GromosParserTests extends Specification {
  "GromosParserTest" >> {
    "[Peptide in Water with 2792 atoms] test with json-events" >> {
      ParserRun.parse(GromosParser, "parsers/gromos/test/examples/eq/eq_peptide_1.omd", "json-events") must_== ParseResult.ParseSuccess
    }
    "[Peptide in Water with 2792 atoms] test with json" >> {
      ParserRun.parse(GromosParser, "parsers/gromos/test/examples/eq/eq_peptide_1.omd", "json") must_== ParseResult.ParseSuccess
    }
  }
}
