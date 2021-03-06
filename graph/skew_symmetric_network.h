/****************************************************************************
 * Copyright (C) 2009-2015 EPAM Systems
 * 
 * This file is part of Indigo toolkit.
 * 
 * This file may be distributed and/or modified under the terms of the
 * GNU General Public License version 3 as published by the Free Software
 * Foundation and appearing in the file LICENSE.GPL included in the
 * packaging of this file.
 * 
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
 * WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 ***************************************************************************/

#ifndef __skew_symmetric_network_h__
#define __skew_symmetric_network_h__

#include "base_cpp/array.h"
#include "base_cpp/exception.h"
#include "graph/graph.h"

namespace indigo {

enum 
{
   ARC_IN,  // Incoming arc
   ARC_OUT  // Outgoing arc
};

/* This data structure defines skew-symmetric integer network
 * used to find maximum skew-symmetric flow.
 * Skew-symmetric network is quadruple (g, symmetry, capacity, source), 
 * where:
 *    g        - skew-symmetric graph with 'symmetry' symmetry 
 *    capacity - bonds capacities
 *    source   - network source
 * 
 * SkewSymmetricNetwork is based on Graph class, that
 * represents undirected graphs. That's why for simplicity
 * bonds in both directions are not supported, but this can
 * be implemented in the future if necessary.
 *
 * Term symmetry is used instead of skew-symmetry for brevity.
 *
 * For more information about skew-symmetric networks and flows 
 * look at these articles:
 *    - Goldberg A.V., Karzanov A.V.: Maximum skew-symmetric 
 *      flows and matchings.
 *    - Goldberg A.V., Karzanov A.V.: Path problems in skew-symmetric 
 *      graphs.
 */
class SkewSymmetricNetwork
{
public:
   // Return graph for network structure querying (vertex neighbours)
   const Graph& g() const;

   void clear ();

   // Set/get network source. 
   // Symmetric vertex for source is the sink of network
   void setSource (int source);
   int  getSource () const;

   // Add vertex and symmetric vertex function.
   // Return created vertex index and optionally symmetric vertex
   int addVertex (int *symmetry_vertex = NULL);
   // Remove vertex and symmetric vertex.
   void removeVertex (int vertex);

   // Add arc and symmetric arc with specified capacity
   int addArc    (int from, int to, int capacity);
   // Remove arc and symmetric arc
   void removeArc (int from, int to);

   int getSymmetricVertex (int vertex) const;
   int getSymmetricArc    (int edge) const;

   int  getArcType      (int edge, int vertex) const;
   int  getArcCapacity  (int edge) const;
   void setArcCapacity  (int edge, int capacity);

   DECL_ERROR;
private:
   Graph _g;
   Array<int> _symmetry;
   int _source;

   struct Arc
   {
      int from, to;
      int capacity;
   };
   Array<Arc> _arcs;
};

}

#endif // __skew_symmetric_network_h__
