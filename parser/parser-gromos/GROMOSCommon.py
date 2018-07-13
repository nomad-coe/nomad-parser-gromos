# Copyright 2018-2018 Berk Onat
# 
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
# 
#     http://www.apache.org/licenses/LICENSE-2.0
# 
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.

import logging
import os

PARSERNAME = "GROMOS"
PROGRAMNAME = "gromos"
PARSERVERSION = "0.0.1"
PARSERMETANAME = PARSERNAME.lower()
PARSERTAG = 'x_' + PARSERMETANAME

PARSER_INFO_DEFAULT = {
        'name'   : PARSERMETANAME+'-parser', 
        'version': PARSERVERSION
}

META_INFO_PATH = os.path.normpath(os.path.join(
    os.path.dirname(os.path.abspath(__file__)), 
    "../../../../nomad-meta-info/meta_info/nomad_meta_info/"+PARSERMETANAME+".nomadmetainfo.json"))

LOGGER = logging.getLogger("nomad."+PROGRAMNAME+"Parser")

def set_excludeList(self):
    """Sets the exclude list for x_

    Returns:
        the list of names
    """
    excludelist = [
        PARSERTAG+'_mdin_verbatim_writeout',
        PARSERTAG+'_dumm_text',
        PARSERTAG+'_dummy',
        PARSERTAG+'_mdin_wt'
        ]
    excludelist.extend([PARSERTAG+'_mdin_file_%s' % fileNL.lower() for fileNL in self.fileDict.keys()])
    excludelist.extend([PARSERTAG+'_mdin_%s' % cntrlNL.lower() for cntrlNL in self.cntrlDict.keys()])
    excludelist.extend([PARSERTAG+'_mdin_%s' % ewaldNL.lower() for ewaldNL in self.ewaldDict.keys()])
    excludelist.extend([PARSERTAG+'_mdin_%s' % qmmmNL.lower() for qmmmNL in self.qmmmDict.keys()])
    return excludelist

def set_includeList():
    """Sets the include list for x_

    Returns:
        the list of names
    """
    includelist = []
    return includelist


