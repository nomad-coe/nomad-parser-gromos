# GROMOS Parser
[NOMAD Laboratory CoE](http://nomad-coe.eu) parser for [GROMOS](http://www.gromos.net)
## Version 0.0.2

This is the parser for GROMOS in [GROMOS](http://www.gromos.net).
The official version lives at:

    git clone git@gitlab.mpcdf.mpg.de:nomad-lab/parser-gromos.git

You can browse it at:

    https://gitlab.rzg.mpg.de/nomad-lab/parser-gromos

It relies on having the nomad-meta-info and the python-common repositories one level higher.
The simplest way to have this is to check out nomad-lab-base recursively:

    git clone --recursive git@gitlab.mpcdf.mpg.de:nomad-lab/nomad-lab-base.git

This parser will be in the directory parsers/gromos of this repository.

## Running and Testing the Parser
### Requirements
The required python packages can be installed with (see [python-common](https://gitlab.rzg.mpg.de/nomad-lab/python-common)):

    pip install -r nomad-lab-base/python-common/requirements.txt

### Usage
GROMOS MD log output files can be parsed with:

    python GROMOSParser.py [path/toFile]

### Test Files
Example log output files of GROMOS can be found in the directory test/examples.
More details about the calculations and files are explained in README file of test/examples.

