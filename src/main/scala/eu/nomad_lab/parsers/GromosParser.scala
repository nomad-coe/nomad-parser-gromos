package eu.nomad_lab.parsers

import eu.nomad_lab
import eu.nomad_lab.DefaultPythonInterpreter
import org.{ json4s => jn }
import eu.{ nomad_lab => lab }
import scala.collection.breakOut

object GromosParser extends SimpleExternalParserGenerator(
  name = "GromosParser",
  parserInfo = jn.JObject(
    ("name" -> jn.JString("GromosParser")) ::
      ("parserId" -> jn.JString("GromosParser" + lab.GromosVersionInfo.version)) ::
      ("versionInfo" -> jn.JObject(
        ("nomadCoreVersion" -> jn.JObject(lab.NomadCoreVersionInfo.toMap.map {
          case (k, v) => k -> jn.JString(v.toString)
        }(breakOut): List[(String, jn.JString)])) ::
          (lab.GromosVersionInfo.toMap.map {
            case (key, value) =>
              (key -> jn.JString(value.toString))
          }(breakOut): List[(String, jn.JString)])
      )) :: Nil
  ),
  mainFileTypes = Seq("text/.*"),
  mainFileRe = """^MD\+\+\s*\s*""".r,
  cmd = Seq(DefaultPythonInterpreter.pythonExe(), "${envDir}/parsers/gromos/parser/parser-gromos/GROMOSParser.py",
    "${mainFilePath}"),
  resList = Seq(
    "parser-gromos/GROMOSParser.py",
    "parser-gromos/GROMOSDictionary.py",
    "parser-gromos/GROMOSCommon.py",
    "parser-gromos/setup_paths.py",
    "nomad_meta_info/public.nomadmetainfo.json",
    "nomad_meta_info/common.nomadmetainfo.json",
    "nomad_meta_info/meta_types.nomadmetainfo.json",
    "nomad_meta_info/gromos.nomadmetainfo.json"
  ) ++ DefaultPythonInterpreter.commonFiles(),
  dirMap = Map(
    "parser-gromos" -> "parsers/gromos/parser/parser-gromos",
    "nomad_meta_info" -> "nomad-meta-info/meta_info/nomad_meta_info",
    "python" -> "python-common/common/python/nomadcore"
  ) ++ DefaultPythonInterpreter.commonDirMapping(),
  metaInfoEnv = Some(lab.meta.KnownMetaInfoEnvs.gromos)
)

